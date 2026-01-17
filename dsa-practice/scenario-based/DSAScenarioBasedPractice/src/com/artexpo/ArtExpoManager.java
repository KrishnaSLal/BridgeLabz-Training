package com.artexpo;

public class ArtExpoManager {

    public static void insertionSort(Registration[] artists) {
        for (int i = 1; i < artists.length; i++) {
            Registration key = artists[i];
            int j = i - 1;

            while (j >= 0 && artists[j].getRegistrationTime() > key.getRegistrationTime()) {
                artists[j + 1] = artists[j];
                j--;
            }
            artists[j + 1] = key;
        }
    }
}
