package health.albert.appointmentmanagement.infra.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Appointment;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.ContactMedium;
import health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity.Disability;
import health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity.TimeSlot;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@ApiModel(description = "Related Entity reference. A related user defines information a specific entity.")
@Validated
@Data
@Entity(name = "related_user")
@Table(name = "related_user")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User extends TrackableEntity {
    @Id
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("birthDate")
    private OffsetDateTime birthDate;

    @JsonProperty("countryOfBirth")
    private String countryOfBirth;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("placeOfBirth")
    private String placeOfBirth;

    @JsonProperty("role")
    private String role;

    @JsonProperty("contactMedium")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = ContactMedium.class)
    private List<ContactMedium> contactMedium;

    @JsonProperty("disability")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Disability.class)
    private List<Disability> disability;

    @JsonProperty("availableTimeSlot")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = TimeSlot.class)
    private List<TimeSlot> availableTimeSlot;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", foreignKey = @ForeignKey(name = "fk_user_appointment"))
    private Appointment appointment;

    public void assignParentToChilds() {
        if (!CollectionUtils.isEmpty(getContactMedium())) {
            for (ContactMedium entity : getContactMedium()) {
                entity.setUser(this);
            }
        }
        if (!CollectionUtils.isEmpty(getDisability())) {
            for (Disability entity : getDisability()) {
                entity.setUser(this);
            }
        }
        if (!CollectionUtils.isEmpty(getAvailableTimeSlot())) {
            for (TimeSlot entity : getAvailableTimeSlot()) {
                entity.setUser(this);
            }
        }
    }
}

