//Story: Hospital Queue Management
//Patients are sorted by check-in time and balanced for quick lookups.
//Scenarios:
//● 🔹 Scenario 1: Patient Registration
//● 🔹 Scenario 2: Discharge/Delete Record
//● 🔹 Scenario 3: Display by Arrival Time



package com.tree.avltree.hospitalqueuemanagement;

import java.util.Scanner;

public class MainHospitalQueueSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalQueueBST queue = new HospitalQueueBST();
        int choice;

        do {
            System.out.println("\n===== Hospital Queue Management =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Discharge Patient");
            System.out.println("3. Display Patients by Arrival Time");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Check-in Time : ");
                    int time = sc.nextInt();
                    queue.register(new Patient(id, name), time);
                    System.out.println("Patient registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to Discharge: ");
                    id = sc.nextInt();
                    queue.discharge(id);
                    System.out.println("Patient discharged ");
                    break;

                case 3:
                    queue.displayPatients();
                    break;

                case 4:
                    System.out.println("Exiting Hospital Queue System");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
