package com.bookbazaar;

class PrintedBook extends Book {

    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    // Flat ₹50 discount for printed books
    @Override
    public double applyDiscount(double price) {
        return price - 50;
    }
}
