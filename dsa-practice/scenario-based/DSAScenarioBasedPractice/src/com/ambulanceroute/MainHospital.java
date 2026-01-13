package com.ambulanceroute;

public class MainHospital {
   public static void main(String[]args) {
	   
	   HospitalUnit route = new HospitalUnit();

       // Initial hospital units
       route.addUnit("Emergency", true);
       route.addUnit("Radiology", false);
       route.addUnit("Surgery", true);
       route.addUnit("ICU", false);

       route.displayUnits();

       route.redirectPatient();

       route.removeUnit("Radiology");

       route.displayUnits();

       route.redirectPatient();
   }
}
