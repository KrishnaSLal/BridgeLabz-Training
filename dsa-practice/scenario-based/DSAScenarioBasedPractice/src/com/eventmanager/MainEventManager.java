package com.eventmanager;
import java.util.Arrays;

public class MainEventManager {

    public static void main(String[] args) {

        int[] ticketPrices = {
            2500, 1200, 5000, 800, 3000,
            4500, 1500, 700, 6000, 2000
        };

        // Sort ticket prices
        EventManager.quickSort(ticketPrices, 0, ticketPrices.length - 1);

        System.out.println("Sorted Ticket Prices:");
        System.out.println(Arrays.toString(ticketPrices));

        // Display cheapest tickets
        System.out.println("\nTop Cheapest Tickets:");
        for (int i = 0; i < Math.min(5, ticketPrices.length); i++) {
            System.out.print(ticketPrices[i] + " ");
        }

        // Display most expensive tickets
        System.out.println("\n\nTop Most Expensive Tickets:");
        for (int i = ticketPrices.length - 1;
             i >= Math.max(ticketPrices.length - 5, 0); i--) {
            System.out.print(ticketPrices[i] + " ");
        }
    }
}
