package health.albert.appointmentmanagement.infra.adapters.appointment;

import health.albert.appointmentmanagement.domain.appointment.port.AppointmentPort;
import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentCreate;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.AppointmentStateType;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentAdapter implements AppointmentPort {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(AppointmentCreate appointmentCreate) {
        var appointmentEntity = new Appointment();
        appointmentEntity.setCategory(appointmentCreate.getCategory());
        appointmentEntity.setDescription(appointmentCreate.getDescription());
        appointmentEntity.setUser(appointmentCreate.getUsers());
        appointmentEntity.setNote(appointmentCreate.getNote());
        appointmentEntity.setAttachment(appointmentCreate.getAttachment());
        appointmentEntity.setValidFor(appointmentCreate.getValidFor());
        appointmentEntity.setStatus(AppointmentStateType.INITIALIZED);
        Appointment savedAppointment = appointmentRepository.save(appointmentEntity);
        return savedAppointment;
    }

}
