package com.movietime;

import java.time.LocalTime;
import java.util.Scanner;

public class MainMovieTime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of shows: ");
        int n = sc.nextInt();
        sc.nextLine();

        ShowTimes[] shows = new ShowTimes[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for show " + (i + 1));

            System.out.print("Movie name: ");
            String name = sc.nextLine();

            System.out.print("Show time (HH:MM): ");
            String timeInput = sc.nextLine();

            LocalTime time = LocalTime.parse(timeInput);

            shows[i] = new ShowTimes(name, time);

            InsertionSortShowTimes.sort(shows, i + 1);
        }

        System.out.println("\nSorted Show Listings:");
        for (ShowTimes show : shows) {
            System.out.println(show);
        }

        sc.close();
    }
}
