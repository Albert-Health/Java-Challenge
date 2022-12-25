package com.ahmetduruer.challenges.java.alberthealth.service;

import com.ahmetduruer.challenges.java.alberthealth.repository.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public final class SlotService {
    private final SlotRepository slotRepository;

    public SlotService(final SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }
}
