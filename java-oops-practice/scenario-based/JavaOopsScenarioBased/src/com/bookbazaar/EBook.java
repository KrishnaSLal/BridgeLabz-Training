package com.bookbazaar;

class EBook extends Book {

    public EBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    // 20% discount for eBooks
    @Override
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
