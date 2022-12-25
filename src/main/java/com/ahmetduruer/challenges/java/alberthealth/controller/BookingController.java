package com.ahmetduruer.challenges.java.alberthealth.controller;

import com.ahmetduruer.challenges.java.alberthealth.entity.Booking;
import com.ahmetduruer.challenges.java.alberthealth.mapper.BookingMapper;
import com.ahmetduruer.challenges.java.alberthealth.model.request.BookingDTO;
import com.ahmetduruer.challenges.java.alberthealth.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    private BookingMapper bookingMapper;

    public BookingController(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    final List<Booking> all() {
        return bookingService.findAll();
    }

    @PostMapping
    final BookingDTO newBook(final @RequestBody BookingDTO bookingDTO) {
        final Booking createdSlot = bookingService.newBooking(bookingMapper.toEntity(bookingDTO));

        return bookingMapper.toDto(createdSlot);
    }

    @GetMapping("/{id}")
    final BookingDTO getById(final @PathVariable UUID id) {
        return bookingMapper.toDto(bookingService.getById(id));
    }

    @GetMapping("/user/{userId}")
    final List<BookingDTO> getByUserId(final @PathVariable UUID userId) {
        return bookingService.getBookingsByUserId(userId)
                .stream()
                .map(booking -> bookingMapper.toDto(booking))
                .collect(Collectors.toList());
    }
}
