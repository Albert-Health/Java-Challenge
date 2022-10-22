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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ApiModel(
        description =
                "Describes the contact medium characteristics that could be used to contact a user")
@Validated
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MediumCharacteristic extends BaseEntity {
    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String id;

    @JsonProperty("city")
    private String city;
    @JsonProperty("contactType")
    private String contactType;
    @JsonProperty("country")
    private String country;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("faxNumber")
    private String faxNumber;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("stateOrProvince")
    private String stateOrProvince;
    @JsonProperty("street1")
    private String street1;
    @JsonProperty("street2")
    private String street2;
    @JsonProperty("type")
    private String type;
}

