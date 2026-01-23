package com.foodfest;

public class Footfall {
    
	private String stallName;
	private int footfall;
	
	
	public Footfall(String stallName, int footfall) {
		
		this.stallName = stallName;
		this.footfall = footfall;
		
	}
	public int getFootfall() {
		return footfall;
	}
	@Override
	public String toString() {
		return "Stall name: " +  stallName + "| Footfall: " + footfall;
	}
	
}