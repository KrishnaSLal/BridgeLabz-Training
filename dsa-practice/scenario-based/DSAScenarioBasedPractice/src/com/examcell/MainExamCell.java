package com.examcell;

import java.util.Scanner;

public class MainExamCell {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Roll Number: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Score: ");
            int score = sc.nextInt();

            students[i] = new Student(rollNo, name, score);
        }

        // Sort students using Merge Sort
        RankList.mergeSort(students, 0, students.length - 1);

        System.out.println("\nState-Level Rank List:");
        int rank = 1;
        for (Student s : students) {
            System.out.println("Rank " + rank++ + " → " + s);
        }

        sc.close();
    }
}

