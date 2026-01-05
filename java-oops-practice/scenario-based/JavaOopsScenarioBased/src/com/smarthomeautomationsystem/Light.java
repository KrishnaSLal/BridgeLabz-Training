package com.smarthomeautomationsystem;

class Light extends Appliance {

    public Light() {
        super(60);
    }

    public Light(int power) {
        super(power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("Light turned ON (" + getPowerConsumption() + "W)");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Light turned OFF");
    }
}
