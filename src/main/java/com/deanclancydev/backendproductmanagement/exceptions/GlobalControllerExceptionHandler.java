package com.deanclancydev.backendproductmanagement.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static com.deanclancydev.backendproductmanagement.constants.ExceptionConstants.HANDLE_ALL_EXCEPTIONS_MESSAGE;


/**
 * The type Custom exception handler.
 */
@ControllerAdvice
@Log4j2
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(final Exception ex, final WebRequest request) {
        log.error(ex);

        return buildErrorResponse(
                ex.getLocalizedMessage(),
                HANDLE_ALL_EXCEPTIONS_MESSAGE,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(DBException.class)
    public final ResponseEntity<ErrorResponse> handleDBException(final Exception ex, final WebRequest request) {
        log.error(ex);

        return buildErrorResponse(
                ex.getLocalizedMessage(),
                HANDLE_ALL_EXCEPTIONS_MESSAGE,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String exceptionMessage, String errorMessage, HttpStatus status) {
        List<String> details = new ArrayList<>();
        details.add(exceptionMessage);
        ErrorResponse error = new ErrorResponse(errorMessage, details);

        return new ResponseEntity<>(error, status);
    }
}

