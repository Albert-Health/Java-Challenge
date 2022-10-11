package com.ardasahin81.javachallenge.repository;

import com.ardasahin81.javachallenge.domain.Slot;

import java.util.List;

public interface SlotRepository extends BaseRepository<Slot> {

    List<Slot> findByOwnerIdAndBookedByNull(Long userId);

}