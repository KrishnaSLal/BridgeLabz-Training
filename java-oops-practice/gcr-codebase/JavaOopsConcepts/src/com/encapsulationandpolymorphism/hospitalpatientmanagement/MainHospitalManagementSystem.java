package com.encapsulationandpolymorphism.hospitalpatientmanagement;

import java.util.ArrayList;
import java.util.List;

public class MainHospitalManagementSystem {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient(101, "Ramesh", 45, 5, 3000);
        Patient p2 = new OutPatient(102, "Sita", 30, 500);

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill: ₹" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("General Checkup");
                mr.addRecord("Prescribed Medicines");
                mr.viewRecords();
            }

            System.out.println("----------------------------");
        }
    }
}
