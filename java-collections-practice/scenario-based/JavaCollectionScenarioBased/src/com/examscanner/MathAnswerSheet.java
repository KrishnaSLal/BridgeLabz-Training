package com.examscanner;

import java.util.List;

public class MathAnswerSheet extends AnswerSheet<String> {

    public MathAnswerSheet(String studentName, List<String> answers) {
        super(studentName, answers);
    }

    @Override
    public int evaluate(List<String> answerKey) {
        int score = 0;
        for (int i = 0; i < Math.min(answers.size(), answerKey.size()); i++) {
            if (answers.get(i).equals(answerKey.get(i))) {
                score++;
            }
        }
        return score;
    }
}
