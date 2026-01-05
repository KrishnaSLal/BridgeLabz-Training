package com.linkedlist.circularlinkedlist.ticketreservation;

import java.util.Scanner;

public class MainTicketReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    system.addTicket(id, customer, movie, seat);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();
                    system.removeTicket(removeId);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;
                case 5:
                    System.out.println("Total Tickets Booked: " + system.totalTickets());
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
