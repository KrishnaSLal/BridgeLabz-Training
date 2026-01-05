package com.sortingalgorithms.selectionsort.examscore;

import java.util.Scanner;

public class MainExamScore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(scores);

        System.out.println("\nSorted Exam Scores (Ascending Order):");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        sc.close();
    }
}
