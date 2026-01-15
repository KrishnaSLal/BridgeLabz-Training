package com.parceltracker;

import java.util.Scanner;

public class MainParcelTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Parcel parcel = new Parcel();
        int choice;

        do {
            System.out.println("\n--- Parcel Tracker ---");
            System.out.println("1. Track Parcel");
            System.out.println("2. Add Checkpoint");
            System.out.println("3. Mark Parcel as Lost");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    parcel.trackParcel();
                    break;

                case 2:
                    System.out.print("Add after stage: ");
                    String after = sc.nextLine();

                    System.out.print("New checkpoint name: ");
                    String checkpoint = sc.nextLine();

                    parcel.addCheckpoint(after, checkpoint);
                    break;

                case 3:
                    parcel.markLost();
                    break;

                case 4:
                    System.out.println("Tracking closed.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
