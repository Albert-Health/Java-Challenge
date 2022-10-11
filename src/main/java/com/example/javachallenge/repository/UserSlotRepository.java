package com.example.javachallenge.repository;

import com.example.javachallenge.entity.UserSlotEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSlotRepository extends CrudRepository<UserSlotEntity, Long> {
    @Query(value = "SELECT * FROM user_slots WHERE reminded IS FALSE AND appointment_time > CURRENT_TIMESTAMP AND appointment_time < NOW() + INTERVAL '16 MINUTES'", nativeQuery = true)
    List<UserSlotEntity> findSlotsToRemind();
}
