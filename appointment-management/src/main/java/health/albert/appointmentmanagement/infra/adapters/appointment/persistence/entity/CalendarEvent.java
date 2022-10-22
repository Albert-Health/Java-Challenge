package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import java.time.OffsetDateTime;

@ApiModel(description = "Reference of a CalendarEvent")
@Getter
@Setter
@Validated
@Embeddable
@NoArgsConstructor
public class CalendarEvent {
    @JsonProperty("appointmentDuration")
    private String appointmentDuration;
    @JsonProperty("appointmentDate")
    private OffsetDateTime appointmentDate;
}

