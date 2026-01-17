package com.sensordata;

public class SensorData {

    private long timestamp; // Unix timestamp or any increasing time value
    private double temperature;

    public SensorData(long timestamp, double temperature) {
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Time: " + timestamp +", Temp: " + temperature + "°C";
    }
}
