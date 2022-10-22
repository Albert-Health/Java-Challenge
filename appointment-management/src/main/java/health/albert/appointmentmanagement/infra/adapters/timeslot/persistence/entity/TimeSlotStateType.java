package health.albert.appointmentmanagement.infra.adapters.timeslot.persistence.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum TimeSlotStateType {

    AVALIABLE("avaliable"),

    RESERVED("reserved"),

    REJECTED("rejected"),

    TERMINATEDWITHERROR("terminatedWithError");

    private String value;

    TimeSlotStateType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TimeSlotStateType fromValue(String text) {
        for (TimeSlotStateType b : TimeSlotStateType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}

