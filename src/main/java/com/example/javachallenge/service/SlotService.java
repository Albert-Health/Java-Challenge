package com.example.javachallenge.service;

import com.example.javachallenge.entity.SlotEntity;
import com.example.javachallenge.entity.UserSlotEntity;
import com.example.javachallenge.repository.SlotRepository;
import com.example.javachallenge.repository.UserSlotRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
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

    @Scheduled(fixedDelayString = "PT15M")
    void appointmentReminder() {
        System.out.println("Attention please!");
        var appointments = userSlotRepository.findAll();
        appointments.forEach(UserSlotEntity::appointmentTimeToString);
    }
}
