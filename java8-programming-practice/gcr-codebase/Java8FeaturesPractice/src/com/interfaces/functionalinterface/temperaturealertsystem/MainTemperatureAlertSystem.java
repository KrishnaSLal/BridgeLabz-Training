package com.interfaces.functionalinterface.temperaturealertsystem;

import java.util.Scanner;
import java.util.function.Predicate;

public class MainTemperatureAlertSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current temperature: ");
        double temperature = sc.nextDouble();

        System.out.print("Enter threshold temperature: ");
        double threshold = sc.nextDouble();

        // Predicate functional interface
        Predicate<Double> isAlert = temp -> temp > threshold;

        if (isAlert.test(temperature)) {
            System.out.println("Temperature crossed threshold");
        } else {
            System.out.println("Temperature is normal");
        }
    }
}

