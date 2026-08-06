package com.healthclinic.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private int doctorId;
    private String name;
    private String specialty;
    private int departmentId;

    public Doctor(String name, String specialty, int departmentId) {
        this.name = name;
        this.specialty = specialty;
        this.departmentId = departmentId;
    }

}