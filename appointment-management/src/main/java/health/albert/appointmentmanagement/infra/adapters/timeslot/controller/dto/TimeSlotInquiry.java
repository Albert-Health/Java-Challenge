package health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto;

import health.albert.appointmentmanagement.domain.common.model.UseCase;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlotStateType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeSlotInquiry implements UseCase {
    private Integer offset;
    private Integer limit;
    private TimeSlotStateType timeSlotStateType;
}
