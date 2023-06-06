package com.example.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;


@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false), LocalDate.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFound(Exception ex, WebRequest request) throws Exception {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false), LocalDate.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public final ResponseEntity<ErrorDetails> handleUserAlreadyExist(Exception ex, WebRequest request) throws Exception {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false), LocalDate.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }
}
