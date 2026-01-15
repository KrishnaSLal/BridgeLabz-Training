package com.examproctor;

import java.util.HashMap;

public class Evaluator {

    // Function to calculate score
    public static int calculateScore(HashMap<Integer, String> studentAnswers) {

        // Correct answers (predefined)
        HashMap<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");

        int score = 0;

        for (int qId : correctAnswers.keySet()) {
            if (correctAnswers.get(qId)
                    .equalsIgnoreCase(studentAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }
}
