package com.example.javachallenge.service;

import com.example.javachallenge.entity.SlotEntity;
import com.example.javachallenge.entity.UserSlotEntity;
import com.example.javachallenge.repository.SlotRepository;
import com.example.javachallenge.repository.UserSlotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class SlotService {

    private final SlotRepository slotRepository;
    private final UserSlotRepository userSlotRepository;

    public SlotService(SlotRepository slotRepository, UserSlotRepository userSlotRepository) {
        this.slotRepository = slotRepository;
        this.userSlotRepository = userSlotRepository;

    }

    public List<SlotEntity> getAllSlots() {
        return (List) slotRepository.findAll();
    }

    @Scheduled(fixedDelayString = "PT1M")
    void appointmentReminder() {
        var appointments = userSlotRepository.findAll();
        appointments.forEach(this::remind);
    }
    public void remind(UserSlotEntity appointment) {
        var appointmentWithInNextFifteenMinutes = appointment.getAppointmentTime().isBefore(LocalDateTime.now().plusMinutes(15));
        if ( appointmentWithInNextFifteenMinutes  && !appointment.getReminded()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            log.info("User with ID {} has appointment with slot ID {} at {} today",
                    appointment.getUserId(),
                    appointment.getSlotId(),
                    appointment.getAppointmentTime().format(formatter)
            );
            appointment.setReminded(true);
            userSlotRepository.save(appointment);

        }
    }
}
