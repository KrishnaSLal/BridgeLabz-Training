//In payroll system, calculate annual salary from monthly salary.

package com.functionalinterface.function.payrollsystem;

import java.util.Scanner;
import java.util.function.Function;

public class MainPayrollSystem {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the salary per month: ");
		double salary = sc.nextDouble();
		
		Function<Double, Double> annualSalary = s -> s*12;
		
		System.out.println("Annual Salary is: " + annualSalary.apply(salary));
		
		sc.close();
	}

}
