package com.example.javachallenge.model;

import com.example.javachallenge.entity.SlotEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Slot {
    private Long id;
    private String description;

    public static Slot toModel(SlotEntity slotEntity) {
        Slot slot = new Slot();
        slot.setId(slotEntity.getId());
        slot.setDescription(slotEntity.getDescription());
        return slot;
    }
}
