package com.functionalinterface.function.celsiustofahrenheit;

import java.util.Scanner;
import java.util.function.Function;

public class MainCelsiusToFahrenheit {
   public static void main(String[] args) {
	   
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the temperature in celsius: ");
	   double temperature = sc.nextDouble();
	   
	   Function<Double, Double> temperatureConverter = t -> (t*1.8)+32;
	   
	   System.out.println("The converted fahrenheit temperature is: "+ temperatureConverter.apply(temperature));
	   
	   sc.close();
   }
}
