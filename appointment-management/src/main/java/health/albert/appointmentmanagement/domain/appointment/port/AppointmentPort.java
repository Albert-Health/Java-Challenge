package health.albert.appointmentmanagement.domain.appointment.port;

import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentCreate;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;

@FunctionalInterface
public interface AppointmentPort {
    Appointment create(AppointmentCreate appointmentCreate);
}
