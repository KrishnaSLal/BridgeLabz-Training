package com.employee.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("EMPLOYEE")
public class Employee {

    @Id
    private int id;

    private String name;

    private String email;

    private String phone;

    private BigDecimal salary;

    private int departmentId;
}