// 10. FleetManager – Vehicle Maintenance Scheduler (Merge Sort)
//Story: A fleet company schedules vehicle maintenance based on mileage. Each depot sends a
//sorted list of vehicles. To create a master schedule, Merge Sort is used to combine these depot
//lists efficiently.
//Key Concepts:
//● Sorted sublists from multiple sources
//● Merge sort for final master list
//● Efficient memory usage for large lists


package com.fleetmanager;

import java.util.Scanner;

public class MainFleetManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        DepotList[] vehicles = new DepotList[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1));
            System.out.print("Vehicle ID: ");
            String id = sc.nextLine();

            System.out.print("Mileage (km): ");
            int mileage = sc.nextInt();
            sc.nextLine();

            vehicles[i] = new DepotList(id, mileage);
        }

        // Merge Sort vehicles by mileage
        FleetManager.mergeSort(vehicles, 0, vehicles.length - 1);

        System.out.println("\nMaintenance Schedule:");
        for (DepotList vehicle : vehicles) {
            System.out.println(vehicle);
        }

        sc.close();
    }
}
