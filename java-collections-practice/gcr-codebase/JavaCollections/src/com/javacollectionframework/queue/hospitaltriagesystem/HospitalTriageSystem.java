package com.javacollectionframework.queue.hospitaltriagesystem;

import java.util.*;

public class HospitalTriageSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // PriorityQueue with custom comparator
        PriorityQueue<Patient> queue = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.getSeverity(), p1.getSeverity())
        );

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter patient details:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Severity (1-10): ");
            int severity = sc.nextInt();
            sc.nextLine();

            queue.add(new Patient(name, severity));
        }

        System.out.println("\nTreatment Order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        sc.close();
    }
}
