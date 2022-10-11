package com.ardasahin81.javachallenge.web;

import com.ardasahin81.javachallenge.domain.Slot;
import com.ardasahin81.javachallenge.service.SlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/slot")
@Slf4j
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/create")
    public Slot createNewSlot(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime
    ) {
        return slotService.createNewSlot(userId, startTime, endTime);
    }

    @GetMapping("/available")
    public List<Slot> getAvailableSlots(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            return slotService.getFreeSlotsForUser(userId);
        }
        return slotService.getFreeSlots();
    }

    @PostMapping("/book")
    public Slot bookSlot(@RequestParam Long slotId, @RequestParam Long userId) {
        return slotService.bookSlot(slotId, userId);
    }

}
