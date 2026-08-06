package com.healthclinic.model;

import java.sql.Timestamp;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Timestamp appointmentDate;
    private String status;
    
    public Appointment(int patientId, int doctorId,Timestamp appointmentDate, String status) {
    	this.patientId = patientId;
    	this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.status = status;
    }
    
}