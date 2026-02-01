package com.interfaces.implementinginterfaces.rentalsystem;

public class Bus implements RentalVehicle {

	@Override
	public void rent() {
		System.out.println("Bus rented");
	}
	public void returnVehicle() {
		System.out.println("Bus returned");
	}
	
}
