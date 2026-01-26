package com.javastreams.countwords;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text file path: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            sc.close();
            return;
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read file using FileReader & BufferedReader
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation and split into words
                String[] words = line
                        .toLowerCase()
                        .replaceAll("[^a-z0-9 ]", "")
                        .split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word,
                                wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading file.");
            e.printStackTrace();
            sc.close();
            return;
        }

        // Sort words by frequency
        List<Map.Entry<String, Integer>> wordList =
                new ArrayList<>(wordCountMap.entrySet());

        wordList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nTop 5 most frequent words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordList) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
            count++;
            if (count == 5) break;
        }

        sc.close();
    }
}
