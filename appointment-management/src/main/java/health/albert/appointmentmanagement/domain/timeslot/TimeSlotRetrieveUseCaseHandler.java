package health.albert.appointmentmanagement.domain.timeslot;

import health.albert.appointmentmanagement.domain.common.DomainComponent;
import health.albert.appointmentmanagement.domain.common.usecase.ObservableUseCasePublisher;
import health.albert.appointmentmanagement.domain.common.usecase.UseCaseHandler;
import health.albert.appointmentmanagement.domain.timeslot.port.TimeSlotPort;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotInquiry;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
public class TimeSlotRetrieveUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<TimeSlot[], TimeSlotInquiry> {

    private final TimeSlotPort timeSlotPort;

    public TimeSlotRetrieveUseCaseHandler(TimeSlotPort timeSlotPort) {
        this.timeSlotPort = timeSlotPort;
        register(TimeSlotInquiry.class, this);
    }

    @Override
    public TimeSlot[] handle(TimeSlotInquiry useCase) {
        return timeSlotPort.retrieveAll(useCase);
    }
}
