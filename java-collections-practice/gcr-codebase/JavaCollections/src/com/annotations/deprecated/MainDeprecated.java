package com.annotations.deprecated;

import java.util.Scanner;

public class MainDeprecated{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LegacyAPI api = new LegacyAPI();

        try {
            System.out.println("Choose feature to call:");
            System.out.println("1. Old Feature (deprecated)");
            System.out.println("2. New Feature (recommended)");
            System.out.print("Enter choice (1 or 2): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    api.oldFeature();  // Warning
                    break;
                case 2:
                    api.newFeature();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
