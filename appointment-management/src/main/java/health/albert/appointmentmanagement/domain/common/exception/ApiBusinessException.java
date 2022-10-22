package health.albert.appointmentmanagement.domain.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiBusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ApiBusinessException(String message) {
        super(message);
    }

    public ApiBusinessException(String message, Exception e) {
        super(message, e);
    }
}