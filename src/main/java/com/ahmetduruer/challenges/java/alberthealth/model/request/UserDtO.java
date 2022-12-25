package com.ahmetduruer.challenges.java.alberthealth.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDtO {
    private UUID id;
    private String name;
    private String surname;
    private String email;
}
