package com.examscanner;

import java.util.*;

public class ResultProcessor {

    public static void processResults(
            List<AnswerSheet<String>> sheets,
            List<String> answerKey) {

        Map<String, Integer> scoreMap = new HashMap<>();

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (AnswerSheet<String> sheet : sheets) {
            int score = sheet.evaluate(answerKey);
            scoreMap.put(sheet.getStudentName(), score);
        }

        pq.addAll(scoreMap.entrySet());

        System.out.println("\nResults (Highest First):");
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
