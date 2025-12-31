package com.objectmodeling.hospital;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getDoctorName());
        }

        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getPatientName());
        }
    }
}
