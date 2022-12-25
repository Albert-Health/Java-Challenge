package com.ahmetduruer.challenges.java.alberthealth.service;

import com.ahmetduruer.challenges.java.alberthealth.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public final class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(final BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
}
