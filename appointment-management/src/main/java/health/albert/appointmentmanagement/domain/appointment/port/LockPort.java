package health.albert.appointmentmanagement.domain.appointment.port;

public interface LockPort {
    void lock(String timeSlotId);

    void unlock(String timeSlotId);
}
