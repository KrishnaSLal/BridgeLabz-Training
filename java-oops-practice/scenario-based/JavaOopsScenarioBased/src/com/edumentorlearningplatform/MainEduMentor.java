package com.edumentorlearningplatform;

import java.util.Scanner;

public class MainEduMentor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Learner input
        System.out.print("Enter Learner Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        System.out.print("Is this a full-time course? (true/false): ");
        boolean isFullTime = sc.nextBoolean();
        sc.nextLine();

        Learner learner = new Learner(name, email, id, isFullTime);

        // Quiz
        Quiz quiz = new Quiz();

        System.out.println("\nAnswer the following question:");
        System.out.println("Is Java a pure object-oriented programming language?");
        String userAnswer = sc.nextLine();

        quiz.attemptQuiz(userAnswer);
        quiz.displayResult();

        // Certificate generation
        learner.generateCertificate();

        sc.close();
    }
}

