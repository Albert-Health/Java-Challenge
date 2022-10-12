package com.ardasahin81.javachallenge.service;

import com.ardasahin81.javachallenge.domain.Slot;
import com.ardasahin81.javachallenge.domain.User;
import com.ardasahin81.javachallenge.exception.*;
import com.ardasahin81.javachallenge.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class SlotServiceImpl extends BaseServiceImpl<Slot, SlotRepository> implements SlotService {

    private final UserService userService;

    public SlotServiceImpl(SlotRepository repository, UserService userService) {
        super(repository);
        this.userService = userService;
    }

    @Override
    public List<Slot> getFreeSlotsForUser(Long userId) {
        return getRepository().findByOwnerIdAndBookedByNull(userId);
    }

    @Override
    public List<Slot> getFreeSlots() {
        return getRepository().findByBookedByNull();
    }

    @Override
    public List<Slot> getBookedSlotsBetween(LocalDateTime time1, LocalDateTime time2) {
        return getRepository().findByBookedByNotNullAndStartTimeBetween(time1, time2);
    }

    @Override
    public Slot createNewSlot(Long userId, LocalDateTime startTime, LocalDateTime endTime) {
        if (!endTime.isAfter(startTime)) {
            throw new SlotTimeException();
        }

        User user = userService.get(userId);

        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        if (checkConflict(user.getSlots(), startTime, endTime)) {
            throw new SlotConflictException();
        }

        Slot newSlot = new Slot();
        newSlot.setStartTime(startTime);
        newSlot.setEndTime(endTime);
        newSlot.setOwner(user);

        save(newSlot);
        return newSlot;
    }

    @Override
    public Slot bookSlot(Long slotId, Long userId) {
        Slot slot = get(slotId);

        if (slot.getBookedBy() != null) {
            throw new SlotBookException();
        }

        if (slot.getOwner().getId().equals(userId)) {
            throw new SlotSelfBookException();
        }

        User user = userService.get(userId);

        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        slot.setBookedBy(user);
        save(slot);

        return slot;
    }

    private boolean checkConflict(Collection<Slot> existingSlots, LocalDateTime startTime, LocalDateTime endTime) {
        if (existingSlots == null) {
            return false;
        }

        for (Slot slot : existingSlots) {
            LocalDateTime slotStart = slot.getStartTime();
            LocalDateTime slotEnd = slot.getEndTime();

            if (startTime.equals(slotStart) || endTime.equals(slotEnd)) {
                return true;
            }

            if (startTime.isAfter(slotStart) && startTime.isBefore(slotEnd)) {
                return true;
            }

            if (endTime.isAfter(slotStart) && (endTime.isBefore(slotEnd))) {
                return true;
            }
        }

        return false;
    }
}
