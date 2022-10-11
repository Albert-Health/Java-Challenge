package com.ardasahin81.javachallenge.service;

import com.ardasahin81.javachallenge.domain.Slot;
import com.ardasahin81.javachallenge.repository.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public class SlotServiceImpl extends BaseServiceImpl<Slot, SlotRepository> implements SlotService {

    public SlotServiceImpl(SlotRepository repository) {
        super(repository);
    }

}
