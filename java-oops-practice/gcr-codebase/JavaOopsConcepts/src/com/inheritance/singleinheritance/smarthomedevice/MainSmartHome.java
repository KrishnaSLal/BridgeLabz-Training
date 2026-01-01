package com.inheritance.singleinheritance.smarthomedevice;

public class MainSmartHome {

    public static void main(String[] args) {

        Thermostat thermostat =
                new Thermostat("TH-101", "ON", 24.5);

        thermostat.displayStatus();
    }
}
