package com.javacollectionframework.map.mergetwomaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMapMerger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        System.out.print("Enter number of entries in Map1: ");
        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map1.put(key, value);
        }

        System.out.print("\nEnter number of entries in Map2: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map2.put(key, value);
        }

        Map<String, Integer> mergedMap = MapMerger.mergeMaps(map1, map2);

        System.out.println("\nMerged Map:");
        System.out.println(mergedMap);

        sc.close();
    }
}
