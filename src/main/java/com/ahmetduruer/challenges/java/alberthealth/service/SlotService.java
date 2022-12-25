package com.ahmetduruer.challenges.java.alberthealth.service;

import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import com.ahmetduruer.challenges.java.alberthealth.error.SlotNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.error.UserNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.repository.SlotRepository;
import com.ahmetduruer.challenges.java.alberthealth.repository.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class SlotService {
    private final SlotRepository slotRepository;

    private final UserRepository userRepository;

    public SlotService(final SlotRepository slotRepository, final UserRepository userRepository) {
        this.slotRepository = slotRepository;
        this.userRepository = userRepository;
    }

    public List<Slot> findAll() {
        return StreamSupport.stream(slotRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    public Slot newSlot(final Slot slot) {
        if (slot.getUser() == null) {
            throw new UserNotFoundException();
        }

        return slotRepository.save(slot);
    }

    public Slot getById(final UUID id) {
        final Optional<Slot> slot = slotRepository.findById(id);

        if (slot.isEmpty()) {
            throw new SlotNotFoundException();
        }

        return slot.get();
    }

    public List<Slot> getAvailableSlotsByUserId(final UUID userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }

        final Specification<Slot> specification = (root, query, builder) -> builder.and(
                builder.equal(root.get("user").get("id"), userId),
                builder.isNull(root.get("booking"))
        );

        return slotRepository.findAll(specification);
    }

    public List<Slot> getAllAvailableSlots() {
        final Specification<Slot> specification = (root, query, builder) -> builder.isNull(root.get("booking"));

        return slotRepository.findAll(specification);
    }
}
