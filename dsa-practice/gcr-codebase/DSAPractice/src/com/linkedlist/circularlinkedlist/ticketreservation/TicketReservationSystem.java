package com.linkedlist.circularlinkedlist.ticketreservation;

class TicketReservationSystem {
    private TicketNode tail; // tail points to the last node, tail.next is head

    public TicketReservationSystem() {
        tail = null;
    }

    // Add new ticket at the end
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber);
        if (tail == null) {
            tail = newTicket;
            tail.next = tail; // points to itself
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully!");
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (tail == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode curr = tail.next;
        TicketNode prev = tail;
        boolean found = false;

        do {
            if (curr.ticketID == ticketID) {
                found = true;
                if (curr == tail && curr.next == tail) { // only one node
                    tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket removed successfully!");
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        if (!found) {
            System.out.println("Ticket ID not found.");
        }
    }

    // Display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        TicketNode curr = tail.next;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + curr.ticketID +
                    ", Customer: " + curr.customerName +
                    ", Movie: " + curr.movieName +
                    ", Seat: " + curr.seatNumber +
                    ", Booking Time: " + curr.bookingTime);
            curr = curr.next;
        } while (curr != tail.next);
    }

    // Search tickets by customer name or movie name
    public void searchTicket(String keyword) {
        if (tail == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        TicketNode curr = tail.next;
        boolean found = false;
        do {
            if (curr.customerName.equalsIgnoreCase(keyword) || curr.movieName.equalsIgnoreCase(keyword)) {
                found = true;
                System.out.println("Ticket ID: " + curr.ticketID +
                        ", Customer: " + curr.customerName +
                        ", Movie: " + curr.movieName +
                        ", Seat: " + curr.seatNumber +
                        ", Booking Time: " + curr.bookingTime);
            }
            curr = curr.next;
        } while (curr != tail.next);

        if (!found) {
            System.out.println("No tickets found for: " + keyword);
        }
    }

    // Count total tickets
    public int totalTickets() {
        if (tail == null) return 0;

        int count = 0;
        TicketNode curr = tail.next;
        do {
            count++;
            curr = curr.next;
        } while (curr != tail.next);

        return count;
    }
}
