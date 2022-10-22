package health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto;

import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlotStateType;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotResponse {
    private String id;
    private TimePeriod validFor;
    private TimeSlotStateType timeSlotStateType;
    private User user;

    public static TimeSlotResponse fromModel(TimeSlot timeSlot) {
        return TimeSlotResponse.builder()
                .id(timeSlot.getId())
                .validFor(timeSlot.getValidFor())
                .timeSlotStateType(timeSlot.getTimeSlotStateType())
                .user(timeSlot.getUser())
                .build();
    }
}
