package com.ardasahin81.javachallenge.schedule;

import com.ardasahin81.javachallenge.service.SlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Slf4j
@Component
public class ReminderTask {
    private static final Integer REMIND_BEFORE_MINUTES = 15;

    private final SlotService slotService;

    public ReminderTask(SlotService slotService) {
        this.slotService = slotService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void checkSlotsToRemind() {

        LocalDateTime startTimeToRemind = LocalDateTime.now()
                .plusMinutes(REMIND_BEFORE_MINUTES)
                .truncatedTo(ChronoUnit.MINUTES);

        slotService.getBookedSlotsBetween(startTimeToRemind, startTimeToRemind.plusSeconds(59)).forEach(slot -> {
            log.info("REMINDER! " +
                    slot.getOwner().getUsername() +
                    " has an appointment with " +
                    slot.getBookedBy().getUsername() +
                    " at " + slot.getStartTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        });

    }
}
