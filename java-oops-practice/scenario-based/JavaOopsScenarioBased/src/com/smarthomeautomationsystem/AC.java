package com.smarthomeautomationsystem;

class AC extends Appliance {

    public AC() {
        super(1500);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("AC cooling started (" + getPowerConsumption() + "W)");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("AC turned OFF");
    }
}
