package health.albert.appointmentmanagement.domain.common.usecase;

import health.albert.appointmentmanagement.domain.common.DomainComponent;
import health.albert.appointmentmanagement.domain.common.exception.ApiBusinessException;
import health.albert.appointmentmanagement.domain.common.model.UseCase;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.Objects;

@Slf4j
@DomainComponent
public class BeanAwareUseCasePublisher implements UseCasePublisher {

    @Override
    @SuppressWarnings("unchecked")
    public <R, T extends UseCase> R publish(Class<R> returnClass, T useCase) {
        var useCaseHandler = (UseCaseHandler<R, T>) UseCaseHandlerRegistry.INSTANCE.detectUseCaseHandlerFrom(useCase.getClass());
        validateUseCaseHandlerDetection(useCase, useCaseHandler);
        return useCaseHandler.handle(useCase);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R, T extends UseCase> void publish(T useCase) {
        var voidUseCaseHandler = (VoidUseCaseHandler<T>) UseCaseHandlerRegistry.INSTANCE.detectVoidUseCaseHandlerFrom(useCase.getClass());
        if (Objects.isNull(voidUseCaseHandler)) {
            var useCaseHandler = (UseCaseHandler<R, T>) UseCaseHandlerRegistry.INSTANCE.detectUseCaseHandlerFrom(useCase.getClass());
            validateUseCaseHandlerDetection(useCase, useCaseHandler);
            useCaseHandler.handle(useCase);
        } else {
            validateVoidUseCaseHandlerDetection(useCase, voidUseCaseHandler);
            voidUseCaseHandler.handle(useCase);
        }
    }

    private <R, T extends UseCase> void validateUseCaseHandlerDetection(T useCase, UseCaseHandler<R, T> useCaseHandler) {
        if (Objects.isNull(useCaseHandler)) {
            log.error("Use case handler cannot be detected for the use case: {}, handlers: {}", useCase, UseCaseHandlerRegistry.INSTANCE.getRegistryForUseCaseHandlers());
            throw new ApiBusinessException("Use case not detected!");
        }
    }

    private <T extends UseCase> void validateVoidUseCaseHandlerDetection(T useCase, VoidUseCaseHandler<T> useCaseHandler) {
        if (Objects.isNull(useCaseHandler)) {
            log.error("Void use case handler cannot be detected for the use case: {}, handlers: {}", useCase, UseCaseHandlerRegistry.INSTANCE.getRegistryForVoidUseCaseHandlers());
            throw new ApiBusinessException("Use case not detected!");
        }
    }

}
