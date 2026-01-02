package com.encapsulationandpolymorphism.ridehailing;

import java.util.ArrayList;
import java.util.List;

public class MainRideHailingApp {

    public static void main(String[] args) {

        List<Vehicle> rides = new ArrayList<>();

        Vehicle v1 = new Car(1, "Rahul", 15);
        Vehicle v2 = new Bike(2, "Amit", 8);
        Vehicle v3 = new Auto(3, "Suresh", 10);

        rides.add(v1);
        rides.add(v2);
        rides.add(v3);

        double distance = 10; // km

        for (Vehicle v : rides) {

            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: ₹" + v.calculateFare(distance));

            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                gps.updateLocation("MG Road");
                gps.getCurrentLocation();
            }

            System.out.println("----------------------------");
        }
    }
}
