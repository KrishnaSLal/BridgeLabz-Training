package com.encapsulationandpolymorphism.vehiclerentalsystem;

import java.util.ArrayList;
import java.util.List;

public class MainVehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle v1 = new Car("KA01AB1234", 1500);
        Vehicle v2 = new Bike("KA02XY5678", 500);
        Vehicle v3 = new Truck("KA03TR9999", 3000);

        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        int rentalDays = 3;

        for (Vehicle v : vehicles) {

            v.displayVehicleInfo();

            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = ((Insurable) v).calculateInsurance();

            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insuranceCost);
            System.out.println("------------------------------");
        }
    }
}
