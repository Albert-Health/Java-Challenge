package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.common.entity.BaseEntity;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ApiModel(description = "Indicates the contact medium that could be used to contact the user.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactMedium extends BaseEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @JsonProperty("mediumType")
    private String mediumType;

    @JsonProperty("preferred")
    private Boolean preferred;

    @JsonProperty("characteristic")
    @JoinColumn(name = "medium_characteristic_id", foreignKey = @ForeignKey(name = "fk_contact_medium_characteristic"))
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            targetEntity = MediumCharacteristic.class)
    private MediumCharacteristic characteristic;

    @JsonProperty("validFor")
    private TimePeriod validFor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_contact_medium_user"))
    private User user;
}

