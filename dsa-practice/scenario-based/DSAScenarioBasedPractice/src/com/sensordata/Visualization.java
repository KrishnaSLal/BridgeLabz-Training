package com.sensordata;

public class Visualization {

    public static void quickSort(SensorData[] data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high);

            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);
        }
    }

    private static int partition(SensorData[] data, int low, int high) {
        long pivot = data[high].getTimestamp();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data[j].getTimestamp() <= pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    private static void swap(SensorData[] data, int i, int j) {
        SensorData temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
