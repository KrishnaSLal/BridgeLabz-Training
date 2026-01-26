package com.javacollectionframework.set.insurancepolicysystem;

import java.time.LocalDate;
import java.util.*;

public class PerformanceComparison {

    public static void main(String[] args) {

        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        Policy samplePolicy = new Policy(
                999,
                "Test User",
                LocalDate.now().plusDays(60),
                "Health",
                5000
        );

        System.out.println("---- HashSet Performance ----");
        testPerformance(hashSet, samplePolicy);

        System.out.println("\n---- LinkedHashSet Performance ----");
        testPerformance(linkedHashSet, samplePolicy);

        System.out.println("\n---- TreeSet Performance ----");
        testPerformance(treeSet, samplePolicy);
    }

    private static void testPerformance(Set<Policy> set, Policy policy) {

        long start, end;

        // Add
        start = System.nanoTime();
        set.add(policy);
        end = System.nanoTime();
        System.out.println("Add Time: " + (end - start) + " ns");

        // Search
        start = System.nanoTime();
        set.contains(policy);
        end = System.nanoTime();
        System.out.println("Search Time: " + (end - start) + " ns");

        // Remove
        start = System.nanoTime();
        set.remove(policy);
        end = System.nanoTime();
        System.out.println("Remove Time: " + (end - start) + " ns");
    }
}

