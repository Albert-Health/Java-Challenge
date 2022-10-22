package health.albert.appointmentmanagement.domain.timeslot;

import health.albert.appointmentmanagement.domain.common.DomainComponent;
import health.albert.appointmentmanagement.domain.common.usecase.ObservableUseCasePublisher;
import health.albert.appointmentmanagement.domain.common.usecase.UseCaseHandler;
import health.albert.appointmentmanagement.domain.timeslot.port.TimeSlotPort;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotCreate;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
public class TimeSlotCreateUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<TimeSlot, TimeSlotCreate> {

    private final TimeSlotPort timeSlotPort;

    public TimeSlotCreateUseCaseHandler(TimeSlotPort timeSlotPort) {
        this.timeSlotPort = timeSlotPort;
        register(TimeSlotCreate.class, this);
    }


    @Override
    public TimeSlot handle(TimeSlotCreate useCase) {
        return timeSlotPort.create(useCase);
    }
}
