package com.inheritance.hybridinheritance.vehiclemanagementsystem;

public class MainVehicle {

    public static void main(String[] args) {

        Vehicle v1 = new ElectricVehicle(150, "Tesla Model 3");
        Vehicle v2 = new PetrolVehicle(180, "Honda City");

        v1.displayInfo();
        ((ElectricVehicle) v1).charge();
        System.out.println();

        v2.displayInfo();
        ((PetrolVehicle) v2).refuel();
    }
}
