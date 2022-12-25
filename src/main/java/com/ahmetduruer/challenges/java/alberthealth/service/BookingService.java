package com.ahmetduruer.challenges.java.alberthealth.service;

import com.ahmetduruer.challenges.java.alberthealth.entity.Booking;
import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import com.ahmetduruer.challenges.java.alberthealth.error.SlotNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.error.UserNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.repository.BookingRepository;
import com.ahmetduruer.challenges.java.alberthealth.repository.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public BookingService(final BookingRepository bookingRepository,
                          UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public List<Booking> findAll() {
        return StreamSupport.stream(bookingRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    public Booking getById(final UUID id) {
        final Optional<Booking> booking = bookingRepository.findById(id);

        if (booking.isEmpty()) {
            throw new SlotNotFoundException();
        }

        return booking.get();
    }

    public Booking newBooking(final Booking booking) {
        if (booking.getUser() == null) {
            throw new UserNotFoundException();
        }

        if (booking.getSlot() == null) {
            throw new SlotNotFoundException();
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(final UUID userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }

        final Specification<Slot> specification = (root, query, builder) -> builder.equal(
                root.get("user").get("id"),
                userId
        );

        return bookingRepository.findAll(specification);
    }
}
