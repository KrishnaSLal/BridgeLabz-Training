package com.healthclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int departmentId;
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}