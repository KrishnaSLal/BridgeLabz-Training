package com.tree.binarysearchtree.universityrecordsystem;

import java.util.Scanner;

public class MainUniversityDigitalRecordSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityRecordBST records = new UniversityRecordBST();
        int choice;

        do {
            System.out.println("\n===== University Digital Record System =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display Sorted Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    records.insert(roll, name);
                    System.out.println("Student record inserted.");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to delete: ");
                    roll = sc.nextInt();
                    records.delete(roll);
                    System.out.println("Student record deleted");
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    roll = sc.nextInt();
                    if (records.search(roll))
                        System.out.println("Student record found.");
                    else
                        System.out.println("Student record not found.");
                    break;

                case 4:
                    System.out.println("\n--- Sorted Student Records ---");
                    records.displayRecords();
                    break;

                case 5:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
