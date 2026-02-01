// Smart Device Control Interface
//○ Scenario: All devices (lights, AC, TV) should have turnOn() and turnOff()
//methods.
//○ Task: Create an interface and implement it in multiple classes.


package com.interfaces.implementinginterfaces;

public class MainSmartHome {
   public static void main(String[] args) {
	   
	   SmartDevice light = new Light();
	   SmartDevice ac = new AC();
	   SmartDevice tv = new TV();
	   
	   System.out.println("*****Turning on all devices*****\n");
	   light.turnOn();
	   ac.turnOn();
	   tv.turnOn();
	   
	   System.out.println("\n*****Turning off all devices***** \n");
	   
	   light.turnOff();
	   ac.turnOff();
	   tv.turnOff();
   }
}
