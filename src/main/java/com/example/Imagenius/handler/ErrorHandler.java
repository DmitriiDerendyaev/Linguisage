package com.example.Imagenius.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentTypeMismatch(MethodArgumentNotValidException e) {
        log.warn("400 {}", e.getMessage());
        return new ErrorResponse("Invalid arguments", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(final ValidationException e) {
        log.warn("400 {}", e.getMessage());
        return new ErrorResponse("Request error", e.getMessage());
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public ErrorResponse handleAlreadyExistException(final DataAlreadyExistException e) {
//        log.info("409 {}", e.getMessage());
//        return new ErrorResponse("Conflict error: ", e.getMessage());
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorResponse handleThrowable(final Throwable e) {
//        log.info("500 {}", e.getMessage(), e);
//        return new ErrorResponse("Server error: ", e.getMessage());
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorResponse handleNotFoundException(final DataNotFoundException e) {
//        log.info("404 {}", e.getMessage());
//        return new ErrorResponse("Element not found: ", e.getMessage());
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse invalidReleaseDateException(final InvalidReleaseDateException e) {
//        log.info("400 {}", e.getMessage());
//        return new ErrorResponse("Release error: ", e.getMessage());
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse invalidDurationException(final InvalidDurationException e) {
//        log.info("400 {}", e.getMessage());
//        return new ErrorResponse("Duration error: ", e.getMessage());
//    }

}