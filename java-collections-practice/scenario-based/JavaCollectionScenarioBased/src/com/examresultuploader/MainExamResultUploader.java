//ExamResultUploader – Bulk Marks Processing
//Story: A school system uploads student marks as .csv files:
//RollNo,Name,Subject,Marks
//101,Ravi,Math,95
//102,Anita,Science,88
//The ExamResultUploader tool must:
//● Read the file using FileReader and BufferedReader
//● Validate each line with Regex (no missing fields, correct marks format)
//● Use Map<String, List<Integer>> to store subject-wise marks
//● Calculate top scorer per subject using PriorityQueue
//● Use Generics to allow support for mid-term, finals, or internal exams
//● Throw custom exceptions for invalid formats or missing marks


package com.examresultuploader;

import java.io.File;
import java.util.*;

public class MainExamResultUploader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter CSV file path: ");
        File file = new File(sc.nextLine());

        if (!file.exists()) {
            System.out.println("File not found!");
        }

        try {
            List<ExamRecord<FinalExam>> records =
                    ExamResultReader.readResults(file, new FinalExam());

            Map<String, List<Integer>> subjectMarks = new HashMap<>();
            Map<String, PriorityQueue<ExamRecord<?>>> toppers = new HashMap<>();

            for (ExamRecord<?> record : records) {

                subjectMarks
                        .computeIfAbsent(record.getSubject(), k -> new ArrayList<>())
                        .add(record.getMarks());

                toppers
                        .computeIfAbsent(record.getSubject(),
                                k -> new PriorityQueue<>(
                                        (a, b) -> b.getMarks() - a.getMarks()))
                        .add(record);
            }

            System.out.println("\nSubject-wise Marks:");
            subjectMarks.forEach((k, v) ->
                    System.out.println(k + " - " + v));

            System.out.println("\nTop Scorers:");
            toppers.forEach((subject, pq) ->
                    System.out.println(subject + " - " + pq.peek()));

        } catch (InvalidRecordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
