package com.javagenerics.multileveluniversitycoursemanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface MainUniversityCourseManagementSystem {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<CourseType> evaluationList = new ArrayList<>();

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nCourse " + i);
            System.out.print("Enter course name: ");
            String courseName = sc.nextLine();

            System.out.println("Select evaluation type:");
            System.out.println("1. Exam-Based");
            System.out.println("2. Assignment-Based");
            System.out.println("3. Research-Based");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Course<ExamCourse> examCourse =
                            new Course<>(courseName, new ExamCourse());
                    examCourse.displayCourse();
                    evaluationList.add(examCourse.getCourseType());
                    break;

                case 2:
                    Course<AssignmentCourse> assignmentCourse =
                            new Course<>(courseName, new AssignmentCourse());
                    assignmentCourse.displayCourse();
                    evaluationList.add(assignmentCourse.getCourseType());
                    break;

                case 3:
                    Course<ResearchCourse> researchCourse =
                            new Course<>(courseName, new ResearchCourse());
                    researchCourse.displayCourse();
                    evaluationList.add(researchCourse.getCourseType());
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("\nEvaluation Process: ");
        UniversityCourseManager.evaluateAllCourses(evaluationList);

        sc.close();
    }
}



