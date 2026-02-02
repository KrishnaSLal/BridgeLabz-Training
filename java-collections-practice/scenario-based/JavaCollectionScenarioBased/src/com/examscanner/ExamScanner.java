package com.examscanner;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ExamScanner {

    // Name + answers (A–D only)
    private static final Pattern VALID_LINE =
            Pattern.compile("^[A-Za-z ]+(,[A-D])+$");

    public static List<AnswerSheet<String>> readAnswerSheets(
            String fileName, String subject) throws IOException {

        List<AnswerSheet<String>> sheets = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (!VALID_LINE.matcher(line).matches()) {
                    System.out.println("Invalid format skipped: " + line);
                    continue;
                }

                String[] parts = line.split(",");
                String name = parts[0];

                List<String> answers =
                        Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));

                if ("Math".equalsIgnoreCase(subject)) {
                    sheets.add(new MathAnswerSheet(name, answers));
                } else {
                    sheets.add(new ScienceAnswerSheet(name, answers));
                }
            }
        }
        return sheets;
    }
}

