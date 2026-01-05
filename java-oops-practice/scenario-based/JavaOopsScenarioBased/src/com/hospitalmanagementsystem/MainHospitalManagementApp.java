package com.hospitalmanagementsystem;

public class MainHospitalManagementApp {
	public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Ravi", "Diabetes", 5);
        Patient p2 = new OutPatient(102, "Anita");

        Doctor d1 = new Doctor(1, "Dr. Sharma", "Cardiology");

        Bill bill = new Bill(500, 3000, 200);

        p1.displayInfo();   // Polymorphism
        p2.displayInfo();
        d1.displayInfo();

        System.out.println("Total Bill Amount: ₹" + bill.calculatePayment());
    }
}
