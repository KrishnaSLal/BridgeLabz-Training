package com.encapsulationandpolymorphism.employeemanagementsystem;

	import java.util.ArrayList;
	import java.util.List;

	public class MainEmployeeManagementSystem {

	    public static void main(String[] args) {

	        List<Employee> employees = new ArrayList<>();

	        Employee e1 = new FullTimeEmployee(101, "Ravi", 50000);
	        Employee e2 = new PartTimeEmployee(102, "Anita", 80, 300);

	        e1.assignDepartment("HR");
	        e2.assignDepartment("IT");

	        employees.add(e1);
	        employees.add(e2);

	        // Polymorphism in action
	        for (Employee emp : employees) {
	            emp.displayDetails();
	            System.out.println("----------------------");
	        }
	    }
	}
