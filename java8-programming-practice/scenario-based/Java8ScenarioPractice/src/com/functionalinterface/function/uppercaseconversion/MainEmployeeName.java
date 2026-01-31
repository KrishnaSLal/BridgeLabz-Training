//Convert employee name into uppercase.


package com.functionalinterface.function.uppercaseconversion;

import java.util.Scanner;
import java.util.function.Function;

public class MainEmployeeName {
   public static void main(String[] args) {
	 
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the name of the employee: ");
	   String name = sc.nextLine();
	   
	   Function<String, String> employeeName = e -> (e.toUpperCase());
	   
	   System.out.println("The name in uppercase is: " + employeeName.apply(name));
	   
	   sc.close();
   }
}
