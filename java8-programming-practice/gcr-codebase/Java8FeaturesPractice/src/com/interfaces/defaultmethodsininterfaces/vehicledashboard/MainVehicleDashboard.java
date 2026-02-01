package com.interfaces.defaultmethodsininterfaces.vehicledashboard;

public class MainVehicleDashboard {

    public static void main(String[] args) {

        Vehicle petrolCar = new PetrolCar();
        Vehicle electricCar = new ElectricCar();

        petrolCar.displaySpeed();
        petrolCar.displayBatteryPercentage();   // default method

        System.out.println();

        electricCar.displaySpeed();
        electricCar.displayBatteryPercentage(); // overridden
    }
}

class PetrolCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Petrol Car Speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Electric Car Speed: 70 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery Level: 65%");
    }
}

