package com.javacollectionframework.map.invertamap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMapInverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> originalMap = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();

            System.out.print("Enter value: ");
            int value = sc.nextInt();

            originalMap.put(key, value);
        }

        Map<Integer, List<String>> invertedMap =
                MapInverter.invertMap(originalMap);

        System.out.println("\nInverted Map:");
        for (Map.Entry<Integer, List<String>> entry : invertedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        sc.close();
    }
}
