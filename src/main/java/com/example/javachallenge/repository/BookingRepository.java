package com.example.javachallenge.repository;

import com.example.javachallenge.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllBySlotBeginTimeGreaterThan(long now);

    List<Booking> findAllBySlotBeginTimeGreaterThanEqualAndSlotBeginTimeLessThan(long time1, long time2);
}
