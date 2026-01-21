//4. FlashDealz – Product Sorting by Discount (Quick Sort)
//Story: An e-commerce platform runs a flash sale with millions of products, each offering
//different discounts. Users want to see the top discounted products instantly. To quickly sort
//such large data, the backend uses Quick Sort, known for its fast average-case performance
//and efficiency.
//Concepts Involved:
//● Quick Sort
//● Large unsorted data
//● Performance optimization


package com.flashdealz;

public class Products {
   
	private String product;
	private float price;
	private double discount;
	
	public Products(String product, float price, float discount) {
		this.product = product;
		this.price = price;
		this.discount = discount;
	}
	public double getDiscount(){
		return discount;
	}
	@Override
	public String toString() {
		return "Product: "+product + ", Price: "+ price + ", Discount: " + discount + "%"+
	"\n------------------------------------------------";
	}
}
