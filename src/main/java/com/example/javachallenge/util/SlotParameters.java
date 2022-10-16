package com.example.javachallenge.util;

import com.example.javachallenge.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SlotParameters {
    @NotBlank(message = "User Id is mandatory!")
    public String userId;
    public User user;
    @NotNull(message = "Begin time is mandatory!")
    public Long begin;
    public Long end;
    public Long durationMinutes;
}
