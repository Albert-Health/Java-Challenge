package health.albert.appointmentmanagement.domain.appointment;

import health.albert.appointmentmanagement.domain.appointment.port.AppointmentPort;
import health.albert.appointmentmanagement.domain.appointment.port.LockPort;
import health.albert.appointmentmanagement.domain.appointment.service.ScheduledTask;
import health.albert.appointmentmanagement.domain.common.DomainComponent;
import health.albert.appointmentmanagement.domain.common.exception.ApiBusinessException;
import health.albert.appointmentmanagement.domain.common.usecase.ObservableUseCasePublisher;
import health.albert.appointmentmanagement.domain.common.usecase.UseCaseHandler;
import health.albert.appointmentmanagement.domain.timeslot.port.TimeSlotPort;
import health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto.AppointmentCreate;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotStatusValueChange;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlotStateType;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

@Slf4j
@DomainComponent
public class AppointmentCreateUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Appointment, AppointmentCreate> {

    private final AppointmentPort appointmentPort;
    private final TimeSlotPort timeSlotPort;
    private final LockPort lockPort;

    public AppointmentCreateUseCaseHandler(AppointmentPort appointmentPort, TimeSlotPort timeSlotPort, LockPort lockPort) {
        this.appointmentPort = appointmentPort;
        this.timeSlotPort = timeSlotPort;
        this.lockPort = lockPort;
        register(AppointmentCreate.class, this);
    }

    @Override
    @Transactional
    public Appointment handle(AppointmentCreate useCase) {
        lockPort.lock(useCase.getRequestedTimeSlotId());
        try {
            Appointment appointment = appointmentPort.create(useCase);
            var timeSlotStatusValueChange = buildTimeSlotStatusValueChange(useCase);
            // change time slot status as reserved
            publish(timeSlotStatusValueChange);
            // calculate 15 minutes earlier before appointment , schedule task with timer task
            scheduleTask(useCase.getRequestedTimeSlotId());
            return appointment;
        } catch (Exception e) {
            log.error("Exception occurred while appointment create, exception details : ", e);
            throw new ApiBusinessException(String.format("Exception occurred while appointment create, exception details :", e.getMessage()));
        } finally {
            lockPort.unlock(useCase.getRequestedTimeSlotId());
        }
    }

    private void scheduleTask(String requestedTimeSlotId) {
        TimeSlot timeSlot = timeSlotPort.retrieve(requestedTimeSlotId);
        TimePeriod validFor = timeSlot.getValidFor();
        if (Objects.nonNull(validFor)) throw new ApiBusinessException("Valid for cannot be null!");
        OffsetDateTime scheduledTime = validFor.getEndDateTime().minusMinutes(15);
        Timer timer = new Timer();
        timer.schedule(new ScheduledTask(), Date.from(scheduledTime.toInstant()));
    }

    private TimeSlotStatusValueChange buildTimeSlotStatusValueChange(AppointmentCreate appointmentCreate) {
        return TimeSlotStatusValueChange.builder()
                .timeSlotId(appointmentCreate.getRequestedTimeSlotId())
                .timeSlotStateType(TimeSlotStateType.RESERVED)
                .build();
    }
}
