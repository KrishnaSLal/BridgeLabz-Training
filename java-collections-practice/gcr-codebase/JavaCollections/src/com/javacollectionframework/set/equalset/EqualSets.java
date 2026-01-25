package com.javacollectionframework.set.equalset;

import java.util.*;

public class EqualSets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First set
        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Second set
        System.out.print("Enter number of elements in Set 2: ");
        int n2 = sc.nextInt();

        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Comparison
        boolean isEqual = set1.equals(set2);
        System.out.println("Are both the sets equal? " + isEqual);

        sc.close();
    }
}
