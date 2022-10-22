package health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.domain.common.model.UseCase;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Attachment;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Note;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@ApiModel(description = "An Appointment is an arrangement to do something or meet someone at a particular time, at a place (for face to face appointment) or in a contact medium (for phone appointment). Skipped properties: id,href,status,creationDate,lastUpdate")
@Validated
@Data
public class AppointmentCreate implements UseCase {
    @JsonProperty("category")
    private String category = null;
    @JsonProperty("description")
    private String description = null;
    @JsonProperty("attachment")
    private List<Attachment> attachment = null;
    @JsonProperty("note")
    private List<Note> note = null;
    @JsonProperty("users")
    private List<User> users = null;
    @JsonProperty("validFor")
    private TimePeriod validFor = null;
    @JsonProperty("requestedTimeSlotId")
    private String requestedTimeSlotId;
}

