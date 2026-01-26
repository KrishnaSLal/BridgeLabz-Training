package com.javacollectionframework.set.insurancepolicysystem;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        System.out.print("Enter number of policies: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter policy details:");

            System.out.print("Policy Number: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.print("Policy Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Expiry Date (YYYY-MM-DD): ");
            LocalDate expiry = LocalDate.parse(sc.nextLine());

            System.out.print("Coverage Type (Health/Auto/Home): ");
            String type = sc.nextLine();

            System.out.print("Premium Amount: ");
            double premium = sc.nextDouble();
            sc.nextLine();

            Policy policy = new Policy(number, name, expiry, type, premium);

            hashSet.add(policy);
            linkedHashSet.add(policy);
            treeSet.add(policy);
        }

        System.out.println("\nAll Policies (HashSet):");
        hashSet.forEach(System.out::println);

        // Policies expiring within 30 days
        System.out.println("\nPolicies expiring within 30 days:");
        LocalDate today = LocalDate.now();
        for (Policy p : hashSet) {
            if (!p.getExpiryDate().isBefore(today)
                    && p.getExpiryDate().isBefore(today.plusDays(30))) {
                System.out.println(p);
            }
        }

        // Filter by coverage type
        System.out.print("\nEnter coverage type to search: ");
        String searchType = sc.nextLine();

        System.out.println("Policies with coverage type " + searchType + ":");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(searchType)) {
                System.out.println(p);
            }
        }

        // Sorted policies
        System.out.println("\nPolicies sorted by expiry date:");
        treeSet.forEach(System.out::println);

        sc.close();
    }
}