package com.linkedlist.singlylinkedlist.studentrecordmanagement;

import java.util.Scanner;

public class MainStudentRecordApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Grade: ");
                    char grade = sc.next().charAt(0);

                    if (choice == 1)
                        list.addAtBeginning(roll, name, age, grade);
                    else if (choice == 2)
                        list.addAtEnd(roll, name, age, grade);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(roll, name, age, grade, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.searchByRoll(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char g = sc.next().charAt(0);
                    list.updateGrade(r, g);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
