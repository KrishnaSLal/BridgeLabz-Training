//6. RoboWarehouse – Shelf Loading Robot (Insertion Sort)
//Story: A robot loads packages onto shelves based on weight. It adds one package at a time
//and must maintain an ascending order by weight for balance. Insertion Sort helps since new
//items are inserted into the sorted list dynamically.
//Key Concepts:
//● Insertion into sorted lists
//● Low memory footprint
//● Ideal for streaming insertions


package com.robowarehouse;

import java.util.Scanner;

public class MainRoboWarehouse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packages to load: ");
        int n = sc.nextInt();

        PackageItem[] packages = new PackageItem[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Package " + (i + 1));

            System.out.print("Package ID: ");
            int id = sc.nextInt();

            System.out.print("Weight (kg): ");
            double weight = sc.nextDouble();

            packages[i] = new PackageItem(id, weight);

            // Sort after each insertion (streaming behavior)
            ShelfLoading.insertionSort(packages);

            System.out.println("\nCurrent Shelf Order:");
            for (int j = 0; j <= i; j++) {
                System.out.println(packages[j]);
            }
        }

        sc.close();
    }
}
