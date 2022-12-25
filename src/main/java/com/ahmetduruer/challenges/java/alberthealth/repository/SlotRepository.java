package com.ahmetduruer.challenges.java.alberthealth.repository;

import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SlotRepository extends CrudRepository<Slot, UUID> {
    List<Slot> findAll(Specification<Slot> specification);

    List<Slot> findByBookingNotNullAndBeginTimeBetween(Long beginTime, Long endTime);
}
