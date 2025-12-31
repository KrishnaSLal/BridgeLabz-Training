package com.objectmodeling.hospital;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private String doctorName;
    private List<Patient> patients;

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
        this.patients = new ArrayList<>();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);
        System.out.println("Doctor " + doctorName +
                " is consulting Patient " + patient.getPatientName());
    }

    public void showPatients() {
        System.out.println("Patients consulted by Dr. " + doctorName + ":");
        for (Patient patient : patients) {
            System.out.println(patient.getPatientName());
        }
    }
}

