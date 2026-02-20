package com.dbmsjdbc.jdbc.librarymanagementsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();

        BookDAO bookDAO = new BookDAO();
        BorrowDAO borrowDAO = new BorrowDAO();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Book");
            System.out.println("2. Search Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    bookDAO.addBook(title, author, category, copies);
                    break;

                case 2:
                    System.out.print("Title filter: ");
                    String t = sc.nextLine();
                    System.out.print("Author filter: ");
                    String a = sc.nextLine();
                    System.out.print("Category filter: ");
                    String c = sc.nextLine();
                    bookDAO.searchBooks(t, a, c);
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Student ID: ");
                    int studentId = sc.nextInt();
                    borrowDAO.borrowBook(bookId, studentId);
                    break;

                case 4:
                    System.out.print("Record ID: ");
                    int recordId = sc.nextInt();
                    borrowDAO.returnBook(recordId);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}