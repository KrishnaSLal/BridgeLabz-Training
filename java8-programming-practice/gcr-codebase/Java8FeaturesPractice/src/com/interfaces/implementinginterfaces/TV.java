package com.interfaces.implementinginterfaces;

public class TV implements SmartDevice {

	@Override
	public void turnOn() {
		System.out.println("TV turned on");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV turned off");
	}
}
