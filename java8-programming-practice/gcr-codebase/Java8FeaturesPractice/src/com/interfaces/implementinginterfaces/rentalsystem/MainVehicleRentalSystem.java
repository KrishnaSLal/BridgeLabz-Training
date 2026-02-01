//Multi-Vehicle Rental System
//○ Scenario: Cars, bikes, and buses share rent() and returnVehicle()
//methods.
//○ Task: Use interface-based design.


package com.interfaces.implementinginterfaces.rentalsystem;

public class MainVehicleRentalSystem {
   public static void main(String[] args) {
	   
	   RentalVehicle bike = new Bike();
	   RentalVehicle bus = new Bus();
	   RentalVehicle car = new Car();
	   
	   System.out.println("***Vehicles on rent***\n");
	   
	   bike.rent();
	   bus.rent();
	   car.rent();
	   
	   System.out.println("\n***Vehicles Returned***\n");
	   
	   bike.returnVehicle();
	   bus.returnVehicle();
	   car.returnVehicle();
   }
}
