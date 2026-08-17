package com.employee.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // =========================
    // EMPLOYEE NOT FOUND
    // =========================

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleEmployeeNotFound(
            EmployeeNotFoundException exception) {

        logger.warn(
                "Employee not found: {}",
                exception.getMessage()
        );

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

    // =========================
    // DEPARTMENT NOT FOUND
    // =========================

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleDepartmentNotFound(
            DepartmentNotFoundException exception) {

        logger.warn(
                "Department not found: {}",
                exception.getMessage()
        );

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