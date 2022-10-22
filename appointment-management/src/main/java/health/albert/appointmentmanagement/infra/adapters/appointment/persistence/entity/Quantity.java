package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;

@Getter
@Setter
@Validated
@Embeddable
@NoArgsConstructor
@ApiModel(description = "An amount in a given unit")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Quantity extends BaseEntity {
    @JsonProperty("amount")
    private Float amount = 1.0f;
    @JsonProperty("units")
    private String units;
}

