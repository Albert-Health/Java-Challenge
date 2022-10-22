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
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ApiModel(description = "Lack or inadequate strength or ability.")
@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Disability extends BaseEntity {
    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @JsonProperty("disabilityCode")
    private String disabilityCode;

    @JsonProperty("disabilityName")
    private String disabilityName;

    @JsonProperty("validFor")
    private TimePeriod validFor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_disability_user"))
    private User user;
}
