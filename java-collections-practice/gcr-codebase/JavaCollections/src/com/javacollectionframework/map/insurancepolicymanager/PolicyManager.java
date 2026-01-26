package com.javacollectionframework.map.insurancepolicymanager;

import java.util.*;
import java.time.LocalDate;

public class PolicyManager {
    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMapPolicies = new TreeMap<>();

    // Add policy
    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve policy by number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    // List policies expiring in next 30 days
    public void listExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("Policies expiring in next 30 days:");
        treeMapPolicies.subMap(today, true, limit, true).values()
                .forEach(list -> list.forEach(System.out::println));
    }

    // List policies by holder
    public void listPoliciesByHolder(String holderName) {
        System.out.println("Policies for " + holderName + ":");
        hashMapPolicies.values().stream()
                .filter(p -> p.getPolicyHolderName().equalsIgnoreCase(holderName))
                .forEach(System.out::println);
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<LocalDate> expiredDates = new ArrayList<>();

        for (Map.Entry<LocalDate, List<Policy>> entry : treeMapPolicies.entrySet()) {
            if (entry.getKey().isBefore(today)) {
                entry.getValue().forEach(p -> {
                    hashMapPolicies.remove(p.getPolicyNumber());
                    linkedHashMapPolicies.remove(p.getPolicyNumber());
                });
                expiredDates.add(entry.getKey());
            }
        }

        expiredDates.forEach(treeMapPolicies::remove);
        System.out.println(expiredDates.size() + " expired date(s) removed.");
    }

    // Display policies in insertion order
    public void displayPoliciesInInsertionOrder() {
        System.out.println("Policies in insertion order:");
        linkedHashMapPolicies.values().forEach(System.out::println);
    }

    // Display policies sorted by expiry
    public void displayPoliciesSortedByExpiry() {
        System.out.println("Policies sorted by expiry date:");
        treeMapPolicies.forEach((date, policies) -> {
            System.out.println("Expiry Date: " + date);
            policies.forEach(System.out::println);
        });
    }

    // Remove policy by number
    public void removePolicy(String policyNumber) {
        Policy removed = hashMapPolicies.remove(policyNumber);
        if (removed != null) {
            linkedHashMapPolicies.remove(policyNumber);
            treeMapPolicies.get(removed.getExpiryDate()).remove(removed);
            System.out.println("Policy removed: " + removed);
        } else {
            System.out.println("Policy not found!");
        }
    }
}
