package com.searching.linearsearch.specificwordinasentence;

import java.util.Scanner;

public class SpecificWordSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of sentences
        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] sentences = new String[n];

        // Take sentences input
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        // Take word to search
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        // Linear search
        String result = searchSentence(sentences, word);

        // Output
        System.out.println("Result: " + result);

        sc.close();
    }

    // Linear search method
    public static String searchSentence(String[] sentences, String word) {

        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
