package com.ahmetduruer.challenges.java.alberthealth.scheduler;

import com.ahmetduruer.challenges.java.alberthealth.entity.Booking;
import com.ahmetduruer.challenges.java.alberthealth.service.SlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Slf4j
@Component
public class BookingReminder {
    private static final Integer BOOKING_REMINDER_TIME = 15;

    @Autowired
    private SlotService slotService;

    @Scheduled(cron = "0 * * * * *")
    public void scheduleBookingReminder() {
        final LocalDateTime startTime = LocalDateTime.now()
                .plusMinutes(BOOKING_REMINDER_TIME)
                .truncatedTo(ChronoUnit.MINUTES);

        final LocalDateTime endTime = startTime.plusSeconds(59);

        final long startTimeMillis = startTime.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli();
        final long endTimeMillis = endTime.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli();

        slotService.getBookedSlotsBetween(startTimeMillis, endTimeMillis).forEach(slot -> {
            final String userFullName = slot.getUser().getName() + " " + slot.getUser().getSurname();
            final Booking booking = slot.getBooking();

            final Instant instant = Instant.ofEpochMilli(slot.getBeginTime());
            final LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            final String formattedDateTime = dateTime.format(formatter);

            log.info("REMINDER: " +
                    userFullName +
                    " has an appointment with " +
                    booking.getUser().getName() +
                    " at " + formattedDateTime);

        });

    }
}