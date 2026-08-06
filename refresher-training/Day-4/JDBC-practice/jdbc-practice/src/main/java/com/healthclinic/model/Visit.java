package com.healthclinic.model;

import java.sql.Timestamp;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    private int visitId;
    private int appointmentId;
    private Timestamp visitDate;
    private String diagnosis;

    public Visit(int appointmentId, Timestamp visitDate, String diagnosis) {
        this.appointmentId = appointmentId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
    }
}