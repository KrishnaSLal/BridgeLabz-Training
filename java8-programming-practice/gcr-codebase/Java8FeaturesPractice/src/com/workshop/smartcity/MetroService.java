package com.workshop.smartcity;

public class MetroService implements TransportService {
    public String getName() {
    	return "Metro"; 
    }
    public double getFare() {
    	return 50; 
    }
    public int getPassengers() {
    	return 100; 
    }
}