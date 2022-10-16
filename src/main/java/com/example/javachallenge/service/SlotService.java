package com.example.javachallenge.service;

import com.example.javachallenge.model.Slot;
import com.example.javachallenge.util.SlotParameters;

import java.util.List;

public interface SlotService {

    boolean createSlots(SlotParameters slotParameters);

    List<Slot> findAvailableSlots(String user);

    boolean bookSlot(Long slotId, String booker);
}
