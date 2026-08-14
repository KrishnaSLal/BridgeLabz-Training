package com.employee.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse>
            handleEmployeeNotFound(
                EmployeeNotFoundException exception) {

        ErrorResponse error =
                new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND.value(),
                    exception.getMessage()
                );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(
            DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse>
            handleDepartmentNotFound(
                DepartmentNotFoundException exception) {

        ErrorResponse error =
                new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND.value(),
                    exception.getMessage()
                );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}