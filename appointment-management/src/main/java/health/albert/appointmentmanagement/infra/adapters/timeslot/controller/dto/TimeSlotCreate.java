package health.albert.appointmentmanagement.infra.adapters.timeslot.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.domain.common.model.UseCase;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.User;
import lombok.Data;

@Data
public class TimeSlotCreate implements UseCase {

    @JsonProperty("validFor")
    private TimePeriod validFor;

    @JsonProperty("validFor")
    private User user;
}
