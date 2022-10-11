package com.example.javachallenge.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "slots")
@Getter
@Setter
@NoArgsConstructor
public class SlotEntity {
    @Id
    private Long id;
    private Long userId;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
