package com.tree.avltree.onlineticketbooking;

import java.util.Scanner;

public class MainOnlineTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketBookingBST events = new TicketBookingBST();
        int choice;

        do {
            System.out.println("\n===== Online Ticket Booking =====");
            System.out.println("1. Insert Event");
            System.out.println("2. Cancel Event");
            System.out.println("3. Show Events in Upcoming Order");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Event ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Event Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Location: ");
                    String loc = sc.nextLine();
                    System.out.print("Enter Start Time (24h format, e.g., 1300): ");
                    int time = sc.nextInt();
                    events.insert(id, name, loc, time);
                    System.out.println("Event added.");
                    break;

                case 2:
                    System.out.print("Enter Start Time of Event to Cancel: ");
                    time = sc.nextInt();
                    events.delete(time);
                    System.out.println("Event cancelled");
                    break;

                case 3:
                    System.out.println("\n--- Upcoming Events ---");
                    events.displayEvents();
                    break;

                case 4:
                    System.out.println("Exiting Ticket Booking System.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
