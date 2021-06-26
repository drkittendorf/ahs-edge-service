package com.adhocsensei.ahsedgeservice.controller;

import com.adhocsensei.ahsedgeservice.exception.InvalidUserCredentialsException;
import com.adhocsensei.ahsedgeservice.exception.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AsSenseiControllerExceptionHandler {
    @ExceptionHandler(value = {InvalidUserCredentialsException.class})
    public ResponseEntity<CustomErrorResponse> outOfRangeExceptionHandler(InvalidUserCredentialsException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.toString());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}
