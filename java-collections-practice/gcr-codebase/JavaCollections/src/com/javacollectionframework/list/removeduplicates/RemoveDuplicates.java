package com.javacollectionframework.list.removeduplicates;

import java.util.*;

public class RemoveDuplicates {

    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        // Input elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Remove duplicates while preserving order
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> result = new ArrayList<>(uniqueSet);
        
        System.out.println("List after removing duplicates:");
        System.out.println(result);

        sc.close();
    }
}
