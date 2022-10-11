package com.example.javachallenge.controller;

import com.example.javachallenge.model.Slot;
import com.example.javachallenge.service.SlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/slot/")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("all")
    public ResponseEntity getAll() {
        var slotEntities = slotService.getAllSlots();
        var slots = slotEntities.stream().map(Slot::toModel).collect(Collectors.toList());
        return ResponseEntity.ok(slots);
    }
}
