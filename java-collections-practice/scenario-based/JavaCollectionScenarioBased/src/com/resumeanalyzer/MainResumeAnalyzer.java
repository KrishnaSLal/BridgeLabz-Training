//1. ResumeAnalyzer – Smart Resume Filtering System
//Story: At HireRight Technologies, HRs receive hundreds of resumes daily. An automated
//system called ResumeAnalyzer is being developed to process .txt and .pdf resumes stored
//in a folder.
//The goal is to read each resume (using I/O Streams), extract contact details (email, phone)
//using Regex, and index them into a Map<String, ResumeData>, where the key is the
//candidate's email.
//The system should support:
//● Reading resumes from a folder
//● Extracting keywords (Java, Python, Spring) using regex
//● Storing candidates in a list sorted by keyword match count
//● Skipping resumes with invalid formats using exception handling

package com.resumeanalyzer;

import java.io.File;
import java.util.*;

public class MainResumeAnalyzer {

    public static void main(String[] args) {

        // Declare ONCE
        File folder = new File("resumes");

        Map<String, ResumeData> resumeMap = new HashMap<>();
        List<ResumeData> resumeList = new ArrayList<>();

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Resume folder not found or inaccessible: "
                    + folder.getAbsolutePath());
            return;
        }

        for (File file : files) {
            try {
                String content = ResumeReader.readResume(file);

                String email = RegexExtractor.extractEmail(content);
                String phone = RegexExtractor.extractPhone(content);
                int keywordCount = RegexExtractor.countKeywords(content);

                if (email == null) {
                    throw new InvalidResumeFormatException(
                            "Email not found in " + file.getName());
                }

                ResumeData data =
                        new ResumeData(email, phone, keywordCount, file.getName());

                resumeMap.put(email, data);
                resumeList.add(data);

            } catch (Exception e) {
                System.out.println("Skipping file: " + e.getMessage());
            }
        }

        // Sort by keyword match count (descending)
        resumeList.sort((a, b) ->
                Integer.compare(b.getKeywordCount(), a.getKeywordCount()));

        System.out.println("\nSorted Candidates:");
        resumeList.forEach(System.out::println);
    }
}
