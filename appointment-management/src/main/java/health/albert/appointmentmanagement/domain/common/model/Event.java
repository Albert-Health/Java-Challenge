package health.albert.appointmentmanagement.domain.common.model;

public interface Event<T> {
    T toModel();
}
