package com.sortingalgorithms.heapsort.jobapplicants;

import java.util.Scanner;

public class MainJobSalary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of job applicants: ");
        int n = sc.nextInt();

        int[] salaries = new int[n];

        System.out.println("Enter expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        HeapSort heapSort = new HeapSort();
        heapSort.sort(salaries);

        System.out.println("\nSorted Salary Demands (Ascending Order):");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }

        sc.close();
    }
}
