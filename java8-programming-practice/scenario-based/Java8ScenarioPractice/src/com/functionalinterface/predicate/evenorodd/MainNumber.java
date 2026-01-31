package com.functionalinterface.predicate.evenorodd;

import java.util.Scanner;
import java.util.function.Predicate;

class Number {

	int number;
	
	Number(int number){
		
		this.number = number;
	}
}
public class MainNumber{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		Number num = new Number(number);
		
		Predicate<Number> evenOdd = n -> n.number%2==0;
		
		if(evenOdd.test(num)) {
			System.out.println("The number is even.");
		}
		else {
			System.out.println("The number is odd");
		}
		sc.close();
	}
}