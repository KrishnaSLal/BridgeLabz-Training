package com.javastreams.datastream;

import java.io.*;
import java.util.Scanner;

public class StudentData {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Store Student Data");
        System.out.println("2. Retrieve Student Data");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        if (choice == 1) {
            storeData(sc, fileName);
        } else if (choice == 2) {
            retrieveData(fileName);
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }

    // Store student data
    private static void storeData(Scanner sc, String fileName) {
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = sc.nextDouble();

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data stored successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing data.");
            e.printStackTrace();
        }
    }

    // Retrieve student data
    private static void retrieveData(String fileName) {
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Details:");
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error while reading data.");
            e.printStackTrace();
        }
    }
}
