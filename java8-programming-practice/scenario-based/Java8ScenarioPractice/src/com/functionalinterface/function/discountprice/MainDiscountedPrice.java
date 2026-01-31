//Convert product price into discounted price.

package com.functionalinterface.function.discountprice;

import java.util.Scanner;
import java.util.function.Function;

public class MainDiscountedPrice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the MRP of the product: ");
		double price = sc.nextDouble();
		
		Function<Double, Double> discountedPrice = d -> d - (d*0.10);
		
		System.out.println("Price after discount : Rs. " + discountedPrice.apply(price));
		
		sc.close();
	}

}
