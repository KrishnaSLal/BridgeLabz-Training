package com.examscanner;

import java.util.*;

public class MainExamScanner {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-collections-practice\\scenario-based\\JavaCollectionScenarioBased\\src\\com\\examscanner\\answers.csv";
        List<String> answerKey =
                List.of("A", "B", "C", "D", "A", "B", "C");

        try {
            List<AnswerSheet<String>> sheets =
                    ExamScanner.readAnswerSheets(fileName, "Math");

            ResultProcessor.processResults(sheets, answerKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
