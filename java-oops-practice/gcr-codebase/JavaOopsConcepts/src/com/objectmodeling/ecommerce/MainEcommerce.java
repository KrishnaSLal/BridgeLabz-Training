package com.objectmodeling.ecommerce;

public class MainEcommerce {

    public static void main(String[] args) {

        Customer customer = new Customer("Rohit");

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1500);

        Order order1 = new Order(101);

        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.addProduct(p3);

        customer.placeOrder(order1);

        System.out.println();
        customer.showOrders();
    }
}
