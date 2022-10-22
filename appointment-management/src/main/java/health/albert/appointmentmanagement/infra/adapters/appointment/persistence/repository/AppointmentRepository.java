package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.repository;

import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, UUID> {
}
