package com.healthclinic.model;

import java.sql.Timestamp;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Timestamp appointmentDate;
    private String status;
}