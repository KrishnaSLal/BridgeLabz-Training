package com.edumentorlearningplatform;

public class Quiz {

    private final String question;          // fixed question
    private final String correctAnswer;     // cannot be modified
    private int score;

    public Quiz() {
        this.question = "Is Java a pure object-oriented programming language?";
        this.correctAnswer = "No";
        this.score = 0;
    }

    public void attemptQuiz(String userAnswer) {
        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            score++;
        }
    }

    public void displayResult() {
        System.out.println("Question: " + question);
        System.out.println("Score: " + score + "/1");
        System.out.println("Percentage: " + (score * 100) + "%");
    }
}

