package com.smarthomeautomationsystem;

class UserController {

    public void controlDevice(Controllable device, boolean turnOn) {
        if (turnOn) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }

    public void compareEnergy(Appliance a1, Appliance a2) {
        if (a1.getPowerConsumption() > a2.getPowerConsumption()) {
            System.out.println("First appliance uses more energy");
        } else if (a1.getPowerConsumption() < a2.getPowerConsumption()) {
            System.out.println("Second appliance uses more energy");
        } else {
            System.out.println("Both appliances use equal energy");
        }
    }
}
