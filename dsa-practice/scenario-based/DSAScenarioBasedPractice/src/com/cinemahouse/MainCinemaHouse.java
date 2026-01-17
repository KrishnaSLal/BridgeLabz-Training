//7. CinemaHouse – Movie Time Sorting (Bubble Sort)
//Story: A small local cinema lists daily movie shows. The screen manager updates showtimes
//manually and prefers a simple sorting logic. Since the number of shows is small (~10), Bubble
//Sort is used.
//Key Concepts:
//● Manual data entry, simple logic
//● Small dataset
//● Minimal code complexity



package com.cinemahouse;

import java.util.Scanner;

public class MainCinemaHouse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movie shows (max 10): ");
        int n = sc.nextInt();
        sc.nextLine();

        MovieShow[] shows = new MovieShow[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Show " + (i + 1));

            System.out.print("Movie Name: ");
            String movieName = sc.nextLine();

            System.out.print("Show Time:");
            int showTime = sc.nextInt();
            sc.nextLine();

            shows[i] = new MovieShow(movieName, showTime);
        }

        // Sort shows by time
        ScreenManager.bubbleSort(shows);

        System.out.println("\nSorted Movie Showtimes:");
        for (MovieShow show : shows) {
            System.out.println(show);
        }

        sc.close();
    }
}

