package com.runtimeanalysis.differentdatastructurecomparison;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PerformanceComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter dataset size (N): ");
        int n = scanner.nextInt();

        System.out.print("Enter element to search: ");
        int target = scanner.nextInt();

        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long startTime = System.nanoTime();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (array[i] == target) {
                found = true;
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ns");

        scanner.close();
    }
}