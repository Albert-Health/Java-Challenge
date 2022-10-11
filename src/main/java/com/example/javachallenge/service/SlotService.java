package com.example.javachallenge.service;

import com.example.javachallenge.entity.SlotEntity;
import com.example.javachallenge.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public List<SlotEntity> getAllSlots() {
        return (List) slotRepository.findAll();
    }
}
