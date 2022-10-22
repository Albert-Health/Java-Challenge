package health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.repository;

import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlotStateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, String> {
    Optional<TimeSlot[]> findAllByTimeSlotStateType(TimeSlotStateType timeSlotStateType);
}
