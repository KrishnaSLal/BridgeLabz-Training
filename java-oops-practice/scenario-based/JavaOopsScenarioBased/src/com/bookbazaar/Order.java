package com.bookbazaar;

class Order {

    private String userName;
    private Book book;
    private int quantity;

    // Order status restricted using access modifier
    private String status = "PLACED";

    public Order(String userName, Book book, int quantity) {
        this.userName = userName;
        this.book = book;
        this.quantity = quantity;
    }

    public double calculateTotalCost() {
        double discountedPrice = book.applyDiscount(book.getPrice());
        return discountedPrice * quantity;   // price × quantity – discount
    }

    // Controlled status update
    protected void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void displayOrder() {
        System.out.println("User: " + userName);
        System.out.println("Book: " + book.getTitle());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
        System.out.println("Order Status: " + status);
    }
}
