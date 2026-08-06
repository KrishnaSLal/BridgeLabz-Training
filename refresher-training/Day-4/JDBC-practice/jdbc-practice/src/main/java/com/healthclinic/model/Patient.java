package com.healthclinic.model;

import java.sql.Date;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private int patientId;
    private String name;
    private String phone;
    private Date dob;
    private String gender;

    public Patient(String name, String phone, Date dob, String gender) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }
}