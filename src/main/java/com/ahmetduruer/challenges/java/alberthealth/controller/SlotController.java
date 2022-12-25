package com.ahmetduruer.challenges.java.alberthealth.controller;

import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import com.ahmetduruer.challenges.java.alberthealth.mapper.SlotMapper;
import com.ahmetduruer.challenges.java.alberthealth.model.request.SlotDTO;
import com.ahmetduruer.challenges.java.alberthealth.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/slots")
public class SlotController {
    private final SlotService slotService;

    @Autowired
    private SlotMapper slotMapper;

    public SlotController(final SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    final List<Slot> all() {
        return slotService.findAll();
    }

    @PostMapping
    final SlotDTO newSlot(final @RequestBody SlotDTO slotDto) {
        final Slot createdSlot = slotService.newSlot(slotMapper.toEntity(slotDto));

        return slotMapper.toDto(createdSlot);
    }

    @GetMapping("/{id}")
    final SlotDTO getById(final @PathVariable UUID id) {
        return slotMapper.toDto(slotService.getById(id));
    }

    @GetMapping("/available/{userId}")
    final List<SlotDTO> getAvailableSlotsByUserId(final @PathVariable UUID userId) {
        return slotService.getAvailableSlotsByUserId(userId)
                .stream()
                .map(slot -> slotMapper.toDto(slot))
                .collect(Collectors.toList());
    }

    @GetMapping("/available")
    final List<SlotDTO> getAllAvailableSlots() {
        return slotService.getAllAvailableSlots()
                .stream()
                .map(slot -> slotMapper.toDto(slot))
                .collect(Collectors.toList());
    }
}
