package com.functionalinterface.predicate.ecommerceapp;

import java.util.Scanner;
import java.util.function.Predicate;

class Order{
	
	double amount;
	
	Order(double amount){
		this.amount = amount;
	}
}
public class MainOrder {
   public static void main(String[]args) {
	   
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("Enter the payable amount on the order:");
	   double amount = sc.nextDouble();
	   
	   Order payable = new Order(amount);
	   
	   Predicate<Order> freedelivery = order -> order.amount>=500;
	   
	   if(freedelivery.test(payable)) {
		   System.out.println("Eligible for free delivery");
	   }
	   else {
			   System.out.println("Not eligible for free delivery");
		   }
	   sc.close();   
   }

}
