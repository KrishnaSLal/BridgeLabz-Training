package com.sortingalgorithms.insertionsort.employeeid;

import java.util.Scanner;

public class MainEmployeeId {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] empIds = new int[n];

        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = sc.nextInt();
        }

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(empIds);

        System.out.println("\nSorted Employee IDs (Ascending Order):");
        for (int id : empIds) {
            System.out.print(id + " ");
        }

        sc.close();
    }
}
