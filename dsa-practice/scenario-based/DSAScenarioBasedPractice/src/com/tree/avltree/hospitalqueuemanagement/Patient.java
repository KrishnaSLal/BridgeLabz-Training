package com.tree.avltree.hospitalqueuemanagement;

import java.util.ArrayList;
import java.util.List;

// Basic patient info
class Patient {
    int patientID;
    String name;

    Patient(int patientID, String name) {
        this.patientID = patientID;
        this.name = name;
    }
}

// BST node representing a check-in time
class PatientNode {
    int checkInTime;
    List<Patient> patients; // multiple patients with same check-in
    PatientNode left, right;

    PatientNode(int checkInTime, Patient p) {
        this.checkInTime = checkInTime;
        this.patients = new ArrayList<>();
        this.patients.add(p);
        left = right = null;
    }
}
