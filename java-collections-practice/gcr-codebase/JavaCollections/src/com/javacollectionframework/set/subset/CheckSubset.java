package com.javacollectionframework.set.subset;

import java.util.*;

public class CheckSubset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input Set 1
        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();

        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements of Set 1:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }

        // Input Set 2
        System.out.print("Enter number of elements in Set 2: ");
        int n2 = sc.nextInt();

        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements of Set 2:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }

        // Check subset
        boolean isSubset = set2.containsAll(set1);

        System.out.println("Is Set 1 a subset of Set 2? " + isSubset);

        sc.close();
    }
}
