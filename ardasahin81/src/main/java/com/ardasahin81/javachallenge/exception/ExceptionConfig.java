package com.ardasahin81.javachallenge.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler({
            SlotBookException.class,
            SlotConflictException.class,
            SlotSelfBookException.class,
            SlotTimeException.class,
            UserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String processError(RuntimeException e) {
        e.printStackTrace();
        return "ERROR: " + e.getMessage();
    }

}
