package com.javacollectionframework.set.settosortedlist;

import java.util.*;

public class SetToSortedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements in the set: ");
        int n = sc.nextInt();

        // HashSet input
        Set<Integer> set = new HashSet<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        // Convert Set to List
        List<Integer> list = new ArrayList<>(set);

        // Sort the list
        Collections.sort(list);
        
        System.out.println("Sorted List:");
        System.out.println(list);

        sc.close();
    }
}
