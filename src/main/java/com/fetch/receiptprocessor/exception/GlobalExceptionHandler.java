package com.fetch.receiptprocessor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        return Collections.singletonMap("description", "The receipt is invalid.");
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(NoSuchElementException ex) {
        return Collections.singletonMap("description", "No receipt found for that ID.");
    }

}
