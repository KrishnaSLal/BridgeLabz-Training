package com.movietime;

public class InsertionSortShowTimes {

    public static void sort(ShowTimes[] shows, int n) {

        for (int i = 1; i < n; i++) {
            ShowTimes key = shows[i];
            int j = i - 1;

            while (j >= 0 && shows[j].getTime().isAfter(key.getTime())) {
                shows[j + 1] = shows[j];
                j--;
            }
            shows[j + 1] = key;
        }
    }
}
