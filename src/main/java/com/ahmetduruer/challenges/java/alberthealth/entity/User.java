package com.ahmetduruer.challenges.java.alberthealth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "`user`")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false)
    private UUID id;

    private String name;

    private String surname;

    private String email;

    private Boolean enabled = true;

    @OneToMany
    private Set<Slot> slots;

    @OneToMany
    private Set<Booking> bookings;

}