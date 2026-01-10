package com.bookbazaar;

public class MainBookBazaar {
    public static void main(String[] args) {

        Book ebook = new EBook("Java Mastery", "James Gosling", 500, 10);
        Book printedBook = new PrintedBook("Clean Code", "Robert C. Martin", 800, 5);

        Order order1 = new Order("Krishna", ebook, 2);
        Order order2 = new Order("Krishna", printedBook, 1);

        order1.displayOrder();
        System.out.println("-----------------------");
        order2.displayOrder();
    }
}