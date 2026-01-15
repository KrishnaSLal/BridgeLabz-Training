package com.smartshelf;

import java.util.Scanner;

public class MainSmartShelf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books to be added: ");
        int size = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        SmartShelf shelf = new SmartShelf(size);

        for (int i = 0; i < size; i++) {
            System.out.print("Enter book name " + (i + 1) + ": ");
            String bookName = sc.nextLine();
            shelf.addBook(new Book(bookName));
        }

        shelf.displayBooks();

        sc.close();
    }
}

