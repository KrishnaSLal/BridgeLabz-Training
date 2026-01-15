package com.examproctor;

import java.util.Scanner;

public class MainExamProctor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExamNavigation navigation = new ExamNavigation();
        AnswerSheet sheet = new AnswerSheet();

        int choice;

        do {
            System.out.println("\nExam Proctor System:");
            System.out.println("1. Visit Question");
            System.out.println("2. Answer Question");
            System.out.println("3. Go Back");
            System.out.println("4. Submit Exam");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter question ID: ");
                    int qId = sc.nextInt();
                    navigation.visitQuestion(qId);
                    break;

                case 2:
                    System.out.print("Enter question ID: ");
                    int questionId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter answer: ");
                    String ans = sc.nextLine();
                    sheet.saveAnswer(questionId, ans);
                    break;

                case 3:
                    Integer last = navigation.goBack();
                    if (last != null)
                        System.out.println("Returned from Question: " + last);
                    break;

                case 4:
                    int score = Evaluator
                            .calculateScore(sheet.getAnswers());
                    System.out.println("Exam submitted!");
                    System.out.println("Final Score: " + score);
                    break;

                case 5:
                    System.out.println("Exiting exam system.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
