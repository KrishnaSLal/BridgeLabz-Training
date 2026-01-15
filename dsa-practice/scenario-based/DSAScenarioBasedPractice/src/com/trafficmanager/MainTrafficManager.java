package com.trafficmanager;

import java.util.Scanner;

public class MainTrafficManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(5);

        int choice;

        do {
            System.out.println("\nTraffic Manager");
            System.out.println("1. Vehicle Arrives");
            System.out.println("2. Vehicle Enters Roundabout");
            System.out.println("3. Vehicle Exits Roundabout");
            System.out.println("4. Display Roundabout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter vehicle number: ");
                    String number = sc.nextLine();
                    waitingQueue.enqueue(number);
                    break;

                case 2:
                    if (!waitingQueue.isEmpty()) {
                        String vehicle = waitingQueue.dequeue();
                        roundabout.addVehicle(vehicle);
                    }
                    break;

                case 3:
                    roundabout.removeVehicle();
                    break;

                case 4:
                    roundabout.display();
                    break;

                case 5:
                    System.out.println("Traffic system closed.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
