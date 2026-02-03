//3. FeedbackGuru – Smart Survey Analyzer
//Story: A retail chain collects feedback in plain .txt files where each line contains customer
//feedback like:
//"Service was amazing. Would rate 9/10. Will visit again."
//They want to create a Java tool called FeedbackGuru that:
//● Reads all .txt feedback files (IO)
//● Uses regex to extract ratings (e.g., 7/10, 9/10)
//● Groups feedback into categories (Positive, Neutral, Negative) using Map<String,
//List<String>>`
//● Uses Generics to allow flexible feedback types (e.g., Product, Service)


package com.feedbackguru;

import java.io.File;
import java.util.*;

public class MainFeedbackGuru {

    public static void main(String[] args) {
    	File folder = new File("feedback");

    	System.out.println("Absolute path: " + folder.getAbsolutePath());
    	System.out.println("Exists: " + folder.exists());
    	System.out.println("Is directory: " + folder.isDirectory());


        try {
            List<String> feedbackLines =
                    FeedbackReader.readAllFeedback(folder);

            Map<String, List<Feedback<String>>> result =
                    FeedbackAnalyzer.analyze(feedbackLines, "Service");

            System.out.println("\nPositive Feedback:");
            result.get("Positive").forEach(System.out::println);

            System.out.println("\nNeutral Feedback:");
            result.get("Neutral").forEach(System.out::println);

            System.out.println("\nNegative Feedback:");
            result.get("Negative").forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
