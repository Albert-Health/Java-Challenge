package health.albert.appointmentmanagement.domain.timeslot;

import health.albert.appointmentmanagement.domain.common.DomainComponent;
import health.albert.appointmentmanagement.domain.common.usecase.ObservableUseCasePublisher;
import health.albert.appointmentmanagement.domain.common.usecase.VoidUseCaseHandler;
import health.albert.appointmentmanagement.domain.timeslot.port.TimeSlotPort;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotStatusValueChange;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
public class TimeSlotStatusValueChangeUseCaseHandler extends ObservableUseCasePublisher implements VoidUseCaseHandler<TimeSlotStatusValueChange> {

    private final TimeSlotPort timeSlotPort;

    public TimeSlotStatusValueChangeUseCaseHandler(TimeSlotPort timeSlotPort) {
        this.timeSlotPort = timeSlotPort;
        register(TimeSlotStatusValueChange.class, this);
    }

    @Override
    public void handle(TimeSlotStatusValueChange useCase) {
        timeSlotPort.changeStatus(useCase);
    }
}
