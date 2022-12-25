package com.ahmetduruer.challenges.java.alberthealth.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookingDTO {
    private UUID id;
    private UUID userId;
    private UUID slotId;
}
