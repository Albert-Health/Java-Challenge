package com.example.javachallenge.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "user_slots")
@Getter
@Setter
@NoArgsConstructor
public class UserSlotEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long slotId;
    private LocalDateTime appointmentTime;
    private Boolean reminded;
    private LocalDateTime createdAt ;
    private LocalDateTime deletedAt;


}
