package com.example.javachallenge.util;

import com.example.javachallenge.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class SlotFactory {
    private static final int DEFAULT_DURATION_MINUTES = 30;

    public static List<Slot> createSlots(SlotParameters parameters) {
        List<Slot> slots = new ArrayList<>();

        if (parameters.begin < (TimeUtil.nowInSeconds() + TimeUtil.minutesToSeconds(15)))
            return slots;

        if (parameters.end == null) {
            slots.add(new Slot(parameters.user, parameters.begin, getSlotEnd(parameters)));
            return slots;
        }

        while (getSlotEnd(parameters) < parameters.end) {
            slots.add(new Slot(parameters.user, parameters.begin, getSlotEnd(parameters)));
            parameters.begin = getSlotEnd(parameters);
        }

        return slots;
    }

    private static long getSlotEnd(SlotParameters parameters) {
        long duration = parameters.durationMinutes == null ? DEFAULT_DURATION_MINUTES : parameters.durationMinutes;
        return parameters.begin + TimeUtil.minutesToSeconds(duration);
    }
}
