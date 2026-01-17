package com.cinemahouse;

public class ScreenManager {

    public static void bubbleSort(MovieShow[] shows) {

        int n = shows.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (shows[j].getShowTime() > shows[j + 1].getShowTime()) {
                    MovieShow temp = shows[j];
                    shows[j] = shows[j + 1];
                    shows[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization
            if (!swapped)
                break;
        }
    }
}
