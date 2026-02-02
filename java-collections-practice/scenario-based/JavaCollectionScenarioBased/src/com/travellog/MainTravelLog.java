package com.travellog;

import java.util.*;

public class MainTravelLog {

    public static void main(String[] args) {

        String fileName = "trips.dat";

        try {
            // Sample trips
            List<Trip> trips = List.of(
                    new Trip("Paris", "France", 7,
                            "Visited Paris and enjoyed Eiffel Tower"),
                    new Trip("Rome", "Italy", 4,
                            "Rome history and Vatican tour"),
                    new Trip("Paris", "France", 6,
                            "Paris cafes and museums"),
                    new Trip("Berlin", "Germany", 8,
                            "Berlin wall and nightlife")
            );

            // Write trips
            TravelLogWriter.writeTrips(trips, fileName);

            // Read trips
            List<Trip> storedTrips =
                    TravelLogReader.readTrips(fileName);

            System.out.println("Cities found using regex:");
            System.out.println(
                    TravelLogAnalyzer.findCitiesUsingRegex(storedTrips));

            System.out.println("\nTrips longer than 5 days:");
            TravelLogAnalyzer.longTrips(storedTrips)
                    .forEach(System.out::println);

            System.out.println("\n Unique countries visited:");
            System.out.println(
                    TravelLogAnalyzer.uniqueCountries(storedTrips));

            System.out.println("\nTop 3 most visited cities:");
            TravelLogAnalyzer.top3Cities(storedTrips)
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
