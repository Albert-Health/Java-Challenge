package com.ardasahin81.javachallenge.repository;

import com.ardasahin81.javachallenge.domain.Slot;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotRepository extends BaseRepository<Slot> {

    List<Slot> findByOwnerIdAndBookedByNull(Long userId);

    List<Slot> findByBookedByNotNullAndStartTimeBetween(LocalDateTime time1, LocalDateTime time2);
    List<Slot> findByBookedByNull();

}