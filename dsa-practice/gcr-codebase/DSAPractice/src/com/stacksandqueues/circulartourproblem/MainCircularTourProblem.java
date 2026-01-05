package com.stacksandqueues.circulartourproblem;

import java.util.Scanner;

public class MainCircularTourProblem {

    // Method to find starting petrol pump
    public static int findStartingPoint(int[] petrol, int[] distance, int n) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];

            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = scanner.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = scanner.nextInt();
        }

        System.out.println("Enter distance to next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = scanner.nextInt();
        }

        int start = findStartingPoint(petrol, distance, n);

        if (start == -1) {
            System.out.println("No possible circular tour.");
        } else {
            System.out.println("Start tour from petrol pump index: " + start);
        }

        scanner.close();
    }
}

