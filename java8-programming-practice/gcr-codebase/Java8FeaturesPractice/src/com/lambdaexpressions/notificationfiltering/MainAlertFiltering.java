//Notification Filtering
//○ Scenario: A hospital app sends patient alerts. Based on user preference, only
//certain alerts should be shown.
//○ Task: Use lambdas with Predicate to filter alerts.


package com.lambdaexpressions.notificationfiltering;

import java.util.*;

public class MainAlertFiltering {

    public static void main(String[] args) {

        List<Alert> alerts = List.of(
                new Alert("EMERGENCY", "Patient heart rate critical"),
                new Alert("MEDICATION", "Take insulin at 8 PM"),
                new Alert("APPOINTMENT", "Doctor visit at 10 AM"),
                new Alert("GENERAL", "Cafeteria closed today")
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter alert type to view:");
        System.out.println("EMERGENCY | MEDICATION | APPOINTMENT | GENERAL");
        String userChoice = sc.nextLine().toUpperCase();

        // Lambda created using user input
        AlertFilter userPreference =
                alert -> alert.getType().equalsIgnoreCase(userChoice);

        filterAlerts(alerts, userPreference);
    }

    // Method using Functional Interface
    public static void filterAlerts(List<Alert> alerts, AlertFilter filter) {
        boolean found = false;
        for (Alert alert : alerts) {
            if (filter.filter(alert)) {
                System.out.println(alert);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No alerts found for selected preference.");
        }
    }
}
