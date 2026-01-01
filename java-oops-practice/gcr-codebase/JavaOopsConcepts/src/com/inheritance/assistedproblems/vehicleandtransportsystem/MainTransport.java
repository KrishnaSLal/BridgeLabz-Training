package com.inheritance.assistedproblems.vehicleandtransportsystem;

public class MainTransport {
	public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 12.5);
        vehicles[2] = new Motorcycle(160, "Petrol", true);

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Details:");
            v.displayInfo();   // Dynamic method dispatch
            System.out.println();
        }
    }
}
