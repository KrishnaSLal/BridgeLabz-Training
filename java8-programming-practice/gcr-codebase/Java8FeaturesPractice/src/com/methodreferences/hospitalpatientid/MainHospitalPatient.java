package com.methodreferences.hospitalpatientid;

//Hospital Patient ID Printing
//○ Scenario: Need to print all patient IDs from a list for admin verification.
//○ Task: Use method references instead of lambdas.


import java.util.*;

class PatientUtils {

    public static void printPatientId(Integer id) {
        System.out.println("Patient ID: " + id);
    }
}


public class MainHospitalPatient {

    public static void main(String[] args) {

        List<Integer> patientIds =
                Arrays.asList(101, 102, 103, 104, 105);

        // Method reference
        PatientPrinter printer = PatientUtils::printPatientId;

        printAllPatients(patientIds, printer);
    }

    // Accepts functional interface
    public static void printAllPatients(List<Integer> ids, PatientPrinter printer) {
        for (Integer id : ids) {
            printer.print(id);
        }
    }
}
