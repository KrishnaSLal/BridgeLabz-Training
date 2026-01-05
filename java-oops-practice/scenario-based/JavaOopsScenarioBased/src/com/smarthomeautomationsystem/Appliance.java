package com.smarthomeautomationsystem;

abstract class Appliance implements Controllable {
    private boolean isOn;
    private int powerConsumption; // watts

    // Default power setting
    public Appliance(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    protected void setOn(boolean status) {
        isOn = status;
    }

    protected boolean isOn() {
        return isOn;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}
