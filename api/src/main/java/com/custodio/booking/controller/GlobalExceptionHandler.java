package com.custodio.booking.controller;

import com.custodio.booking.dto.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    ErrorResponseDTO runtimeException(final RuntimeException runtimeException) {
        log.error(runtimeException.getLocalizedMessage(), runtimeException);
        return new ErrorResponseDTO(runtimeException);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorResponseDTO constraintViolationException(final MethodArgumentNotValidException exception) {
        log.error(exception.getLocalizedMessage(), exception);
        var violations = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ErrorResponseDTO(violations);
    }
}
