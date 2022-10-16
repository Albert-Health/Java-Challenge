package com.example.javachallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public User user;

    public Long beginTime;

    public Long endTime;

    public Slot(User user, Long begin, Long end) {
        this.user = user;
        this.beginTime = begin;
        this.endTime = end;
    }
}
