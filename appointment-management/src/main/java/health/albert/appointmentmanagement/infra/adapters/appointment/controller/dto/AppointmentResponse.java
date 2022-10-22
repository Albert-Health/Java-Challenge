package health.albert.appointmentmanagement.infra.adapters.appointment.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.AppointmentStateType;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Attachment;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Note;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("category")
    private String category;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private AppointmentStateType status;
    @JsonProperty("validFor")
    private TimePeriod validFor;
    @JsonProperty("note")
    private List<Note> note;
    @JsonProperty("user")
    private List<User> user;
    @JsonProperty("attachment")
    private List<Attachment> attachment;

    public static AppointmentResponse fromModel(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .category(appointment.getCategory())
                .description(appointment.getDescription())
                .status(appointment.getStatus())
                .validFor(appointment.getValidFor())
                .note(appointment.getNote())
                .user(appointment.getUser())
                .attachment(appointment.getAttachment())
                .build();
    }
}

