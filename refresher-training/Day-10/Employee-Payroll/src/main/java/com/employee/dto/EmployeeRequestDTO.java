package com.employee.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(
        min = 2,
        max = 100,
        message = "Name must be between 2 and 100 characters"
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(
        min = 10,
        max = 15,
        message = "Phone must be between 10 and 15 characters"
    )
    private String phone;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than zero")
    private BigDecimal salary;

    @NotNull(message = "Department ID is required")
    @Positive(message = "Department ID must be greater than zero")
    private Integer departmentId;
}