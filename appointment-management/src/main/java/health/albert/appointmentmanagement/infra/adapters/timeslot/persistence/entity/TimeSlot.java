package health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import health.albert.appointmentmanagement.infra.common.entity.TimePeriod;
import health.albert.appointmentmanagement.infra.common.entity.TrackableEntity;
import health.albert.appointmentmanagement.infra.common.entity.User;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity(name = "timeslot")
@Table(name = "timeslot")
public class TimeSlot extends TrackableEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @JsonProperty("validFor")
    private TimePeriod validFor;

    @JsonProperty("timeSlotStateType")
    private TimeSlotStateType timeSlotStateType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_timeslot_user"))
    private User user;

}

