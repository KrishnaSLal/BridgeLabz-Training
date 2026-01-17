package com.sensordata;

import java.util.Scanner;

public class MainCropMonitor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sensor readings: ");
        int n = sc.nextInt();

        SensorData[] readings = new SensorData[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter Sensor Reading " + (i + 1));

            System.out.print("Timestamp: ");
            long timestamp = sc.nextLong();

            System.out.print("Temperature (°C): ");
            double temperature = sc.nextDouble();

            readings[i] = new SensorData(timestamp, temperature);
        }

        // Sort by timestamp
        Visualization.quickSort(readings, 0, readings.length - 1);

        System.out.println("\nSorted Sensor Data (by Timestamp):");
        for (SensorData data : readings) {
            System.out.println(data);
        }

        sc.close();
    }
}
