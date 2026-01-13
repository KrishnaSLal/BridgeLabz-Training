package com.bookshelf;

import java.util.Scanner;

public class MainBookShelf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookShelf shelf = new BookShelf();

        while (true) {
            System.out.println("Library Menu: ");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Display Catalog");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();

                    Book book = new Book(title, author, isbn);
                    shelf.addBook(genre, book);
                    break;

                case 2:
                    System.out.print("Enter Genre: ");
                    String borrowGenre = sc.nextLine();

                    System.out.print("Enter ISBN: ");
                    String borrowIsbn = sc.nextLine();

                    shelf.borrowBook(borrowGenre, borrowIsbn);
                    break;

                case 3:
                    shelf.displayCatalog();
                    break;

                case 4:
                    System.out.println("Exiting Library System.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}