package com.javacollectionframework.list.frequencyofelements;

import java.util.*;

public class ElementFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // user input  of elements to be stored 
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> list = new ArrayList<>();

        //input
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        // Frequency map
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        System.out.println("Frequency of elements:");
        System.out.println(frequencyMap);

        sc.close();
    }
}
