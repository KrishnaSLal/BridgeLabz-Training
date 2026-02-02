//IoT Sensor Readings
//○ Scenario: Print all readings above threshold.
//○ Task: Use streams with forEach().

package com.streamapi.sensorreadings;

import java.util.*;
import java.util.stream.*;

public class MainSensorReadings {
    public static void main(String[] args) {

        List<Double> sensorReadings = Arrays.asList(
                28.5, 32.1, 25.0, 40.3, 29.8, 35.6
        );

        double threshold = 30.0;

        System.out.println("Sensor readings above threshold (" + threshold + "):");

        sensorReadings.stream()
                      .filter(reading -> reading > threshold) 
                      .forEach(reading ->
                          System.out.println("High Reading: " + reading)
                      );
    }
}
