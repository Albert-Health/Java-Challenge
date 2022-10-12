package com.ardasahin81.javachallenge.service;

import com.ardasahin81.javachallenge.domain.Slot;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotService extends BaseService<Slot> {

    List<Slot> getFreeSlotsForUser(Long userId);

    List<Slot> getFreeSlots();

    List<Slot> getBookedSlotsBetween(LocalDateTime time1, LocalDateTime time2);

    Slot createNewSlot(Long userId, LocalDateTime startTime, LocalDateTime endTime);

    Slot bookSlot(Long slotId, Long userId);
}
