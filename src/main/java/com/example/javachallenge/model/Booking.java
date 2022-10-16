package com.example.javachallenge.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Booking {

    @Id
    public Long id;

    @OneToOne
    @JoinColumn(name = "slot_id")
    public Slot slot;

    @ManyToOne
    @JoinColumn(name = "booked_user_id")
    public User user;

    public Long bookTime;

    public Booking(Slot slot, User user) {
        this.id = slot.id;
        this.slot = slot;
        this.user = user;
        this.bookTime = System.currentTimeMillis() / 1000;
    }
}
