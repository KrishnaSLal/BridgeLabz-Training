package com.objectmodeling.hospital;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String patientName;
    private List<Doctor> doctors;

    public Patient(String patientName) {
        this.patientName = patientName;
        this.doctors = new ArrayList<>();
    }

    public String getPatientName() {
        return patientName;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void showDoctors() {
        System.out.println("Doctors consulted by " + patientName + ":");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getDoctorName());
        }
    }
}
