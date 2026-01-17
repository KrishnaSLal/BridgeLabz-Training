package com.artexpo;

public class Registration {
	
	 private String name;
	 private int registrationTime;

	 public Registration(String name, int registrationTime) {
	     this.name = name;
	     this.registrationTime = registrationTime;
	    }

	 public int getRegistrationTime() {
	        return registrationTime;
	    }
	    @Override
	 public String toString() {
	        return name + " (Registered at: " + registrationTime + " mins)";
	    }
}