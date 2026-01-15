package com.examproctor;

import java.util.Stack;

public class ExamNavigation {

    private Stack<Integer> navigationStack = new Stack<>();

    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    public Integer goBack() {
        if (navigationStack.isEmpty()) {
            System.out.println("No previous questions!");
            return null;
        }
        return navigationStack.pop();
    }
}
