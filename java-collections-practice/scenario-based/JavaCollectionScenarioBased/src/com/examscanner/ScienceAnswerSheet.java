package com.examscanner;

import java.util.List;

public class ScienceAnswerSheet extends AnswerSheet<String> {

    public ScienceAnswerSheet(String studentName, List<String> answers) {
        super(studentName, answers);
    }

    @Override
    public int evaluate(List<String> answerKey) {
        int score = 0;
        for (int i = 0; i < Math.min(answers.size(), answerKey.size()); i++) {
            if (answers.get(i).equalsIgnoreCase(answerKey.get(i))) {
                score++;
            }
        }
        return score;
    }
}
