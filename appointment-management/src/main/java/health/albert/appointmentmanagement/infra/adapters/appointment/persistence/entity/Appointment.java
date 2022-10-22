package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.TrackableEntity;
import health.albert.appointmentmanagement.infra.common.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@ApiModel(description = "An Appointment is an arrangement to do something or meet someone at a particular time, at a place (for face to face appointment) or in a contact medium (for phone appointment).")
@Validated
@Data
@Entity(name = "appointment")
@Table(name = "appointment")
public class Appointment extends TrackableEntity {
    @Id
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
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Note.class)
    private List<Note> note;

    @JsonProperty("user")
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = User.class)
    private List<User> user;

    @JsonProperty("attachment")
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Attachment.class)
    private List<Attachment> attachment;

    public void assignParentToChilds() {
        if (!CollectionUtils.isEmpty(getAttachment())) {
            for (Attachment entity : getAttachment()) {
                entity.setAppointment(this);
            }
        }
        if (!CollectionUtils.isEmpty(getNote())) {
            for (Note entity : getNote()) {
                entity.setAppointment(this);
            }
        }
        if (!CollectionUtils.isEmpty(getUser())) {
            for (User entity : getUser()) {
                entity.setAppointment(this);
            }
        }
    }
}

