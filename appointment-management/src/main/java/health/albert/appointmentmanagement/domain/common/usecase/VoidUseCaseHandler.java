package health.albert.appointmentmanagement.domain.common.usecase;


import health.albert.appointmentmanagement.domain.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {

    void handle(T useCase);
}
