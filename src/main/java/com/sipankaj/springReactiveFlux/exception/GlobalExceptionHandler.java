package com.sipankaj.springReactiveFlux.exception;


import com.sipankaj.springReactiveFlux.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<Object> handleAllException(ApiException apiException) {
        return new ResponseEntity<>(ErrorResponse.builder().errorMessage(apiException.getMessage()).errorCode(1).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
