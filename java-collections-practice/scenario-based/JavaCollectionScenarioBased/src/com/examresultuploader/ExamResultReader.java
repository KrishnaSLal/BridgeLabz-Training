package com.examresultuploader;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ExamResultReader {

    private static final Pattern LINE_PATTERN =
        Pattern.compile("\\d+,\\w+,[A-Za-z]+,\\d{1,3}");

    public static <T extends ExamType>
    List<ExamRecord<T>> readResults(File file, T examType)
            throws IOException, InvalidRecordException {

        List<ExamRecord<T>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                if (!LINE_PATTERN.matcher(line).matches()) {
                    throw new InvalidRecordException("❌ Invalid format: " + line);
                }

                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3]);
                if (marks < 0 || marks > 100) {
                    throw new InvalidRecordException("❌ Invalid marks: " + line);
                }

                records.add(new ExamRecord<>(
                        data[0], data[1], data[2], marks, examType));
            }
        }
        return records;
    }
}
