package com.tourmate;

import java.util.Scanner;

public class MainTourMate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Trip type
        System.out.print("Enter trip type (1-Domestic, 2-International): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        // Basic trip details
        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter trip duration (days): ");
        int duration = sc.nextInt();

        System.out.print("Enter your total budget: ");
        double budget = sc.nextDouble();

        // Transport
        System.out.print("Enter transport cost: ");
        double transportCost = sc.nextDouble();
        Transport transport = new Transport(transportCost);

        // Hotel
        System.out.print("Enter hotel cost per day: ");
        double hotelCostPerDay = sc.nextDouble();
        Hotel hotel = new Hotel(hotelCostPerDay, duration);

        // Activity
        System.out.print("Enter activity cost: ");
        double activityCost = sc.nextDouble();
        Activity activity = new Activity(activityCost);

        Trip trip;

        if (choice == 1) {
            trip = new DomesticTrip(destination, budget, duration, transport, hotel, activity);
        } else {
            trip = new InternationalTrip(destination, budget, duration, transport, hotel,activity);
        }

        System.out.println("\nBooking Trip...");
        trip.book();

        System.out.print("\nDo you want to cancel the trip? (yes/no): ");
        sc.nextLine();
        String cancelChoice = sc.nextLine();

        if (cancelChoice.equalsIgnoreCase("yes")) {
            trip.cancel();
        }

        sc.close();
    }
}
