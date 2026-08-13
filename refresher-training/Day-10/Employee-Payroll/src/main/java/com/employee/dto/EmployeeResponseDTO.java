package com.employee.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private int id;

    private String name;

    private String email;

    private String phone;

    private BigDecimal salary;

    private int departmentId;
}