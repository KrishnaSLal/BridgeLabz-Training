package com.feedbackguru;

import java.util.*;
import java.util.regex.*;

public class FeedbackAnalyzer {

    // Extract rating like 7/10, 9/10
    private static final Pattern RATING_PATTERN =
            Pattern.compile("(\\d{1,2})/10");

    public static <T> Map<String, List<Feedback<T>>> analyze(
            List<String> lines, T feedbackType) {

        Map<String, List<Feedback<T>>> categorized =
                new HashMap<>();

        categorized.put("Positive", new ArrayList<>());
        categorized.put("Neutral", new ArrayList<>());
        categorized.put("Negative", new ArrayList<>());

        for (String line : lines) {
            try {
                Matcher matcher = RATING_PATTERN.matcher(line);

                if (!matcher.find()) {
                    throw new IllegalArgumentException("Rating not found");
                }

                int rating = Integer.parseInt(matcher.group(1));

                Feedback<T> feedback =
                        new Feedback<>(feedbackType, line, rating);

                if (rating >= 8) {
                    categorized.get("Positive").add(feedback);
                } else if (rating >= 5) {
                    categorized.get("Neutral").add(feedback);
                } else {
                    categorized.get("Negative").add(feedback);
                }

            } catch (Exception e) {
                // Graceful handling of bad lines
                System.out.println("Skipped invalid feedback: " + line);
            }
        }
        return categorized;
    }
}
