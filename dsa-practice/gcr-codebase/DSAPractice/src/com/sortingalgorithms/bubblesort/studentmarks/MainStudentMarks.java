package com.sortingalgorithms.bubblesort.studentmarks;

import java.util.Scanner;

public class MainStudentMarks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(marks);

        System.out.println("\nSorted Marks (Ascending Order):");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        sc.close();
    }
}
