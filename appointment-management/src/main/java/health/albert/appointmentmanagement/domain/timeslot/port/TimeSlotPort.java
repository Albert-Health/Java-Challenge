package health.albert.appointmentmanagement.domain.timeslot.port;

import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotCreate;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotInquiry;
import health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto.TimeSlotStatusValueChange;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;

public interface TimeSlotPort {
    TimeSlot create(TimeSlotCreate timeSlotCreate);

    TimeSlot retrieve(String timeSlotId);

    TimeSlot[] retrieveAll(TimeSlotInquiry useCase);

    void changeStatus(TimeSlotStatusValueChange valueChange);
}
