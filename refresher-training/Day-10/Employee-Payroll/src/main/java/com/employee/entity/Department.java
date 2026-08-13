package com.employee.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("DEPARTMENT")
public class Department {

    @Id
    private int id;

    private String name;
}