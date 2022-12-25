package com.ahmetduruer.challenges.java.alberthealth.repository;

import com.ahmetduruer.challenges.java.alberthealth.entity.Booking;
import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID> {
    List<Booking> findAll(Specification<Slot> specification);

}
