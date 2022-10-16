package com.example.javachallenge.repository;

import com.example.javachallenge.model.Slot;
import com.example.javachallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findAllByUserAndBeginTimeGreaterThan(User user, long now);

    List<Slot> findAllByBeginTimeGreaterThan(long now);
}
