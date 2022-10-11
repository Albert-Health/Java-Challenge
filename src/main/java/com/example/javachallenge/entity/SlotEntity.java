package com.example.javachallenge.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "slots")
@Getter
@Setter
@NoArgsConstructor
public class SlotEntity {
    @Id
    private Long id;
    private String description;
    private Date createdAt;
    private Date deletedAt;
}
