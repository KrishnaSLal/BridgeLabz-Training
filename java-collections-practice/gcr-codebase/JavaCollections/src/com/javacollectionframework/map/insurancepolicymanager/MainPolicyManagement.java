package com.javacollectionframework.map.insurancepolicymanager;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainPolicyManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PolicyManager manager = new PolicyManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\nInsurance Policy Management System: ");
            System.out.println("1. Add Policy");
            System.out.println("2. Display Policies in Insertion Order");
            System.out.println("3. Display Policies Sorted by Expiry Date");
            System.out.println("4. Find Policy by Policy Number");
            System.out.println("5. List Policies by Holder Name");
            System.out.println("6. List Policies Expiring in Next 30 Days");
            System.out.println("7. Remove Expired Policies");
            System.out.println("8. Remove Policy by Number");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Policy Number: ");
                    String number = sc.nextLine();
                    System.out.print("Enter Policy Holder Name: ");
                    String holder = sc.nextLine();
                    System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
                    System.out.print("Enter Premium Amount: ");
                    double premium = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    manager.addPolicy(new Policy(number, holder, date, premium));
                    System.out.println("Policy added successfully!");
                }
                case 2 -> manager.displayPoliciesInInsertionOrder();
                case 3 -> manager.displayPoliciesSortedByExpiry();
                case 4 -> {
                    System.out.print("Enter Policy Number: ");
                    String number = sc.nextLine();
                    Policy p = manager.getPolicyByNumber(number);
                    System.out.println(p != null ? p : "Policy not found.");
                }
                case 5 -> {
                    System.out.print("Enter Holder Name: ");
                    String holder = sc.nextLine();
                    manager.listPoliciesByHolder(holder);
                }
                case 6 -> manager.listExpiringPolicies();
                case 7 -> manager.removeExpiredPolicies();
                case 8 -> {
                    System.out.print("Enter Policy Number to remove: ");
                    String number = sc.nextLine();
                    manager.removePolicy(number);
                }
                case 9 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
