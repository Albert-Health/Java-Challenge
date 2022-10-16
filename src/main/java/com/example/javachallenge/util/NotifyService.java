package com.example.javachallenge.util;

import com.example.javachallenge.model.Booking;
import com.example.javachallenge.repository.BookingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotifyService {

    private final BookingRepository bookingRepository;

    public NotifyService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void notifyUpcomingAppointments() {
        long now = TimeUtil.nowInSeconds();
        List<Booking> bookings = bookingRepository
                .findAllBySlotBeginTimeGreaterThanEqualAndSlotBeginTimeLessThan(now + TimeUtil.minutesToSeconds(15), now + TimeUtil.minutesToSeconds(16));
        bookings.stream().forEach(booking -> System.out.println(booking.user + ", you have an appointment with " + booking.slot.user + " within 15 minutes!"));
    }
}
