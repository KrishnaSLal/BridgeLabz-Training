package com.hospitalqueue;

import java.util.Scanner;

public class MainHospital {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Criticality (1-10): ");
            int criticality = sc.nextInt();
            sc.nextLine(); // consume newline

            patients[i] = new Patient(name, criticality);
        }

        System.out.println("\nBefore Sorting:");
        for (Patient p : patients) {
            p.display();
        }

        HospitalQueue.sortByCriticality(patients);

        System.out.println("\nAfter Sorting by Criticality:");
        for (Patient p : patients) {
            p.display();
        }

        sc.close();
    }
}
