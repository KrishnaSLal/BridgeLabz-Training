package com.eventease;

import java.util.*;

public class MainEventEase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Organizer (User)
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter your user ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        User organizer = new User(name, email, userId);

        // Event details
        System.out.print("Enter Event Name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter Event Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Event Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Number of Attendees: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> attendees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Attendee " + (i + 1) + " name: ");
            attendees.add(sc.nextLine());
        }

        // Event type
        System.out.println("Choose Event Type: 1. Birthday  2. Conference");
        int type = sc.nextInt();
        sc.nextLine();

        // Optional services
        System.out.print("Add catering cost? (0 if none): ");
        double catering = sc.nextDouble();
        System.out.print("Add decoration cost? (0 if none): ");
        double decoration = sc.nextDouble();
        sc.nextLine();

        Event event;
        if (type == 1) {
            event = new BirthdayEvent(eventName, location, date, attendees, catering, decoration);
        } else {
            event = new ConferenceEvent(eventName, location, date, attendees, catering, decoration);
        }

        // Schedule
        event.schedule();
        event.displayEventDetails();

        // Reschedule example
        System.out.print("\nEnter new date to reschedule (or press Enter to skip): ");
        String newDate = sc.nextLine();
        if (!newDate.isEmpty()) {
            event.reschedule(newDate);
            event.displayEventDetails();
        }

        // Cancel example
        System.out.print("\nDo you want to cancel the event? (yes/no): ");
        String cancelChoice = sc.nextLine();
        if (cancelChoice.equalsIgnoreCase("yes")) {
            event.cancel();
        }

        System.out.println("\nOrganizer: " + organizer.getName() + " (" + organizer.getEmail() + ")");
        System.out.println("Thank you for using EventEase!");

        sc.close();
    }
}
