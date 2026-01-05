package com.linkedlist.circularlinkedlist.ticketreservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;

        // Set booking time as current time
        this.bookingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        this.next = null;
    }
}
