package com.example.javachallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object s2) {
        if (this == s2) return true;
        if (s2 == null || getClass() != s2.getClass()) return false;
        Slot slot = (Slot) s2;
        return user.userId.equals(slot.user.userId)
                && ((beginTime >= slot.beginTime && beginTime < slot.endTime)
                || (endTime > slot.beginTime && endTime <= slot.endTime));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, beginTime, endTime);
    }
}
