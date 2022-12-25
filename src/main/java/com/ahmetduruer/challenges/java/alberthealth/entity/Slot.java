package com.ahmetduruer.challenges.java.alberthealth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "`slot`")
public class Slot {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false)
    private UUID id;

    private Long beginTime;

    private Long endTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "slot", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Booking booking;
}