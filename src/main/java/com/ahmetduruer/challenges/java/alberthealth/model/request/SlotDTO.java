package com.ahmetduruer.challenges.java.alberthealth.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SlotDTO {
    private UUID id;
    private Long beginTime;
    private Long endTime;
    private UUID userId;
}
