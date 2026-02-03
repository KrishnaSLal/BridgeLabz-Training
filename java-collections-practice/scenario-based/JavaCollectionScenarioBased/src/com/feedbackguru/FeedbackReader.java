package com.feedbackguru;

import java.io.*;
import java.util.*;

public class FeedbackReader {

    public static List<String> readAllFeedback(File folder) throws IOException {

        List<String> feedbackLines = new ArrayList<>();

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null) {
            throw new FileNotFoundException("Feedback folder not found");
        }

        for (File file : files) {
            try (BufferedReader br =
                         new BufferedReader(new FileReader(file))) {

                String line;
                while ((line = br.readLine()) != null) {
                    feedbackLines.add(line);
                }
            }
        }
        return feedbackLines;
    }
}
