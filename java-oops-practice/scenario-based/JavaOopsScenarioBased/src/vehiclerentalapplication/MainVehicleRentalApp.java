/*2. Vehicle Rental Application
Scenario: Build a system for renting bikes, cars, and trucks to customers.
Concepts Used:
● Class: Vehicle, Bike, Car, Truck, Customer

Scenario-based Problems
● Constructors: Custom constructors for different vehicle types
● Access Modifiers: protected for vehicle attributes to allow subclass access
● Interface: Rentable with method calculateRent(int days)
● Operators: Used in rent calculation (e.g., baseRate × days ± surcharges)
● OOP:
○ Abstraction: Rentable abstracts rental behavior
○ Inheritance: Car, Bike, Truck inherit from Vehicle
○ Polymorphism: Rent calculation differs by vehicle type
○ Encapsulation: All fields hidden behind getters/setters*/


package vehiclerentalapplication;

public class MainVehicleRentalApp {
    public static void main(String[] args) {

        Customer c1 = new Customer(1, "Krishna");

        Vehicle v1 = new Bike(101, "Hero");
        Vehicle v2 = new Car(102, "Hyundai");
        Vehicle v3 = new Truck(103, "Tata");

        c1.rentVehicle(v1, 3);
        System.out.println("-----------------");
        c1.rentVehicle(v2, 2);
        System.out.println("-----------------");
        c1.rentVehicle(v3, 1);
    }
}
