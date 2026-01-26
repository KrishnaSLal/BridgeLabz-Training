package com.javacollectionframework.map.wordfrequencycounter;

import java.util.Map;
import java.util.Scanner;

public class MainWordFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        Map<String, Integer> result = WordFrequencyCounter.countWords(filePath);

        System.out.println("\nWord Frequencies:");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        sc.close();
    }
}
