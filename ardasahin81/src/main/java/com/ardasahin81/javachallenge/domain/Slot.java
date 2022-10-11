package com.ardasahin81.javachallenge.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = {"owner", "bookedBy"})
@RequiredArgsConstructor
@Entity
@Table(name = "challenge_slot", uniqueConstraints = @UniqueConstraint(columnNames = {"startTime", "ownerId"}))
public class Slot extends Base {

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "bookedBy")
    @JsonIdentityReference(alwaysAsId = true)
    private User bookedBy;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

}
