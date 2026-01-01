package com.inheritance.hybridinheritance.vehiclemanagementsystem;

interface Refuelable {
    void refuel();
}
class ElectricVehicle extends Vehicle {

    ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println("Electric vehicle is charging ⚡");
    }
}
