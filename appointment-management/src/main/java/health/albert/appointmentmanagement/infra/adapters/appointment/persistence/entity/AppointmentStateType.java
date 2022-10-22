package health.albert.appointmentmanagement.infra.adapters.appointment.persistence.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AppointmentStateType {

    INITIALIZED("initialized"),

    CONFIRMED("confirmed"),

    CANCELLED("cancelled"),

    COMPLETED("completed"),

    FAILED("failed");

    private String value;

    AppointmentStateType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static AppointmentStateType fromValue(String text) {
        for (AppointmentStateType b : AppointmentStateType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}

