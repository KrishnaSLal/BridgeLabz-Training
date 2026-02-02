//Word Frequency Counter
//○ Scenario: Analyze a paragraph for word occurrence.
//○ Task: Use Collectors.toMap().

package com.collectors.wordfrequencycounter;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        // Normalize text: lowercase & remove punctuation
        paragraph = paragraph.toLowerCase()
                             .replaceAll("[^a-zA-Z ]", "");

        Map<String, Integer> wordFrequency =
                Arrays.stream(paragraph.split("\\s+"))
                      .collect(Collectors.toMap(
                              word -> word,      // key
                              word -> 1,         // value
                              Integer::sum       // merge function
                      ));

        System.out.println("\nWord Frequency:");
        wordFrequency.forEach((word, count) ->
                System.out.println(word + " : " + count));

        sc.close();
    }
}
