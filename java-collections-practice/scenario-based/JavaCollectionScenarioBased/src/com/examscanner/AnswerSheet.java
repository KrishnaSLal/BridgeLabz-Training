package com.examscanner;

import java.util.List;

public abstract class AnswerSheet<T> {

    protected String studentName;
    protected List<T> answers;

    public AnswerSheet(String studentName, List<T> answers) {
        this.studentName = studentName;
        this.answers = answers;
    }

    public String getStudentName() {
        return studentName;
    }

    public abstract int evaluate(List<T> answerKey);
}
