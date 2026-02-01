//Custom Sorting in E-Commerce
//○ Scenario: An online shop wants to sort products differently based on sales
//campaigns (by price, rating, discount).
//○ Task: Use a lambda with Comparator to sort products dynamically.


package com.lambdaexpressions.customsorting;

import java.util.*;


class Product{
	
	String name;
	double price;
    double rating;
    double discount;
    
    Product(String name, double price, double rating, double discount){
    	
    	this.name = name;
    	this.price = price;
    	this.rating = rating;
    	this.discount = discount;
    	
    }
    
    @Override
    public String toString() {
    	return name +", " + "Price: " + price +", " + "Rating: " + rating +", "+ "Discount: " + discount;
    }
}
public class MainCustomSorting {
   public static void main(String[] args) {
	   
	   List<Product> products = new ArrayList<>();
       products.add(new Product("Mobile", 15000, 4.5, 10));
       products.add(new Product("Laptop", 55000, 4.7, 20));
       products.add(new Product("Headphones", 2000, 4.2, 30));
       products.add(new Product("Smartwatch", 8000, 4.0, 15));

       ProductSorter priceSorter = () -> (p1, p2) -> Double.compare(p1.price, p2.price);

       products.sort(priceSorter.sort());
       System.out.println("Sorted by Price:");
       products.forEach(System.out::println);

       ProductSorter ratingSorter = () -> (p1, p2) -> Double.compare(p2.rating, p1.rating);

       products.sort(ratingSorter.sort());
       System.out.println("\n Sorted by Rating:");
       products.forEach(System.out::println);

       ProductSorter discountSorter = () -> (p1, p2) -> Double.compare(p2.discount, p1.discount);

       products.sort(discountSorter.sort());
       System.out.println("\n Sorted by Discount:");
       products.forEach(System.out::println);
   }

}
