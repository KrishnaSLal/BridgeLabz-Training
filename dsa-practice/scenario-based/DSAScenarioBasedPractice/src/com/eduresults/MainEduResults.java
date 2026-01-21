//3. EduResults – Rank Sheet Generator (Merge Sort)
//Story: An educational board compiles marks of thousands of students from different districts.
//Each district submits a sorted list of students by score. The main server needs to merge and
//sort all these lists into a final state-wise rank list. Merge Sort ensures efficiency and maintains
//stability for duplicate scores.
//Concepts Involved:
//● Merge Sort
//● Merging sorted sublists
//● Large datasets with stable sorting

package com.eduresults;

import java.util.Scanner;

public class MainEduResults {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Marks[] students = new Marks[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            System.out.print("District: ");
            String district = sc.nextLine();

            students[i] = new Marks(district, name, rollNo, marks);
        }
        System.out.println("\nFinal State-wise Rank List:");
        RankList.mergeSort(students, 0, students.length - 1);
        printStudents(students);
        sc.close();
    }

    private static void printStudents(Marks[] students) {
        for (Marks s : students) {
            System.out.println(s);
        }
    }
}
