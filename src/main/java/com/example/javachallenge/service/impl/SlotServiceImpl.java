package com.example.javachallenge.service.impl;

import com.example.javachallenge.model.Booking;
import com.example.javachallenge.model.Slot;
import com.example.javachallenge.model.User;
import com.example.javachallenge.repository.BookingRepository;
import com.example.javachallenge.repository.SlotRepository;
import com.example.javachallenge.repository.UserRepository;
import com.example.javachallenge.service.SlotService;
import com.example.javachallenge.util.SlotFactory;
import com.example.javachallenge.util.SlotParameters;
import com.example.javachallenge.util.TimeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;

    private final UserRepository userRepository;

    private final BookingRepository bookingRepository;

    public SlotServiceImpl(SlotRepository slotRepository,
                           UserRepository userRepository,
                           BookingRepository bookingRepository) {
        this.slotRepository = slotRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public boolean createSlots(SlotParameters slotParameters) {
        Optional<User> userOpt = userRepository.findById(slotParameters.userId);
        if (!userOpt.isPresent())
            return false;

        slotParameters.user = userOpt.get();

        List<Slot> newSlots = SlotFactory.createSlots(slotParameters);
        if (newSlots.isEmpty())
            return true;

        List<Slot> slots = slotRepository.findAllByBeginTimeGreaterThan(TimeUtil.nowInSeconds()).stream()
                .filter(slot -> slot.user.userId.equals(slotParameters.userId))
                .collect(Collectors.toList());
        if (!slots.isEmpty())
            newSlots.removeAll(slots);

        slotRepository.saveAll(newSlots);

        return true;
    }

    @Override
    public List<Slot> findAvailableSlots(String user) {
        Optional<User> userOpt = userRepository.findById(user);
        if (!userOpt.isPresent())
            return new ArrayList<>();

        List<Slot> slots = slotRepository.findAllByUserAndBeginTimeGreaterThan(userOpt.get(), TimeUtil.nowInSeconds());
        if (slots.isEmpty())
            return slots;

        List<Booking> bookings = bookingRepository.findAllBySlotBeginTimeGreaterThan(TimeUtil.nowInSeconds());
        if (!bookings.isEmpty()) {
            slots = slots.stream().filter(slot -> bookings.stream()
                    .filter(booking -> booking.id == slot.id).count() == 0)
                    .collect(Collectors.toList());
        }

        return slots;
    }

    @Override
    public boolean bookSlot(Long slotId, String booker) {
        Optional<Slot> slotOpt = slotRepository.findById(slotId);
        if (!slotOpt.isPresent())
            return false;

        if (slotOpt.get().beginTime <= (TimeUtil.nowInSeconds() + TimeUtil.minutesToSeconds(15)))
            return false;

        Optional<User> userOpt = userRepository.findById(booker);
        if (!userOpt.isPresent())
            return false;

        Booking booking = new Booking(slotOpt.get(), userOpt.get());

        if (bookingRepository.existsById(slotId))
            return false;

        bookingRepository.save(booking);

        return true;
    }
}
