package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.OffsetDateTime;

@ApiModel(description = "Extra information about a given entity")
@Validated
@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Note extends BaseEntity {
    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @JsonProperty("author")
    private String author;
    @JsonProperty("date")
    private OffsetDateTime date;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", foreignKey = @ForeignKey(name = "fk_note_appointment"))
    private Appointment appointment;
}

