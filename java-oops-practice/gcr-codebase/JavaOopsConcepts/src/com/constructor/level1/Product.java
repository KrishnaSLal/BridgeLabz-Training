package com.constructor.level1;

public class Product {

	// Instance variables
    String productName;
    double price;

    // Class variable (shared by all objects)
    static int totalProducts = 0;

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment whenever a product is created
    }

    // Instance method
    void displayProductDetails() {
        System.out.println(
            "Product Name: " + productName +
            ", Price: ₹" + price
        );
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 700);
        Product p3 = new Product("Keyboard", 1500);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        Product.displayTotalProducts();
    }
}
