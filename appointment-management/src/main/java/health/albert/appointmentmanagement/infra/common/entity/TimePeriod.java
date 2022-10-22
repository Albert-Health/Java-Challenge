package health.albert.appointmentmanagement.infra.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Validated
@Embeddable
@NoArgsConstructor
@ApiModel(
        description =
                "A period of time, either as a deadline (endDateTime only) a startDateTime only, or both")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TimePeriod {
    @JsonProperty("endDateTime")
    private OffsetDateTime endDateTime;
    @JsonProperty("startDateTime")
    private OffsetDateTime startDateTime;
}

