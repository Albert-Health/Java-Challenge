package com.ahmetduruer.challenges.java.alberthealth.repository;

import com.ahmetduruer.challenges.java.alberthealth.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID> {

}
