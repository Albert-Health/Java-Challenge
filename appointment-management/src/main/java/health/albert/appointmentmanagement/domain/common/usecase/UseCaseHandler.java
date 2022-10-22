package health.albert.appointmentmanagement.domain.common.usecase;


import health.albert.appointmentmanagement.domain.common.model.UseCase;

public interface UseCaseHandler<R, T extends UseCase> {

    R handle(T useCase);
}
