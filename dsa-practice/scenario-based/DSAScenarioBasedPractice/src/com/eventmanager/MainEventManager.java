package com.eventmanager;

import java.util.Arrays;
import java.util.Scanner;

public class MainEventManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of tickets from user
        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();

        int[] ticketPrices = new int[n];

        // Take ticket price
        System.out.println("Enter ticket prices:");
        for (int i = 0; i < n; i++) {
            ticketPrices[i] = sc.nextInt();
        }

        // Sort ticket prices using Quick Sort
        EventManager.quickSort(ticketPrices, 0, ticketPrices.length - 1);

        System.out.println("\nSorted Ticket Prices:");
        System.out.println(Arrays.toString(ticketPrices));

        // output
        System.out.println("\nTop Cheapest Tickets:");
        for (int i = 0; i < Math.min(5, ticketPrices.length); i++) {
            System.out.print(ticketPrices[i] + " ");
        }

        // Display most expensive tickets
        System.out.println("\nTop Most Expensive Tickets:");
        for (int i = ticketPrices.length - 1;
             i >= Math.max(ticketPrices.length - 5, 0); i--) {
            System.out.print(ticketPrices[i] + " ");
        }

        sc.close();
    }
}
