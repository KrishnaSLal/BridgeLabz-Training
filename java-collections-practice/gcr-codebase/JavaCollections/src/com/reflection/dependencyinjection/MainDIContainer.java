package com.reflection.dependencyinjection;

import java.util.Scanner;

public class MainDIContainer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Dynamically get a Car object with Engine injected
            Car myCar = DIContainer.getBean(Car.class);

            System.out.println("Starting your car");
            myCar.drive();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
