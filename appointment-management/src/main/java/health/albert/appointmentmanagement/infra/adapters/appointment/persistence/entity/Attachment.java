package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.common.entity.BaseEntity;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@ApiModel(description = "Complements the description of an element (for instance a product) through video, pictures...")
@Getter
@Setter
@Entity
@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment extends BaseEntity {
    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @JsonProperty("attachmentType")
    private String attachmentType;

    @JsonProperty("content")
    private String content;

    @JsonProperty("description")
    private String description;

    @JsonProperty("mimeType")
    private String mimeType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("size")
    private Quantity size;

    @JsonProperty("validFor")
    private TimePeriod validFor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", foreignKey = @ForeignKey(name = "fk_attachment_appointment"))
    private Appointment appointment;

}

