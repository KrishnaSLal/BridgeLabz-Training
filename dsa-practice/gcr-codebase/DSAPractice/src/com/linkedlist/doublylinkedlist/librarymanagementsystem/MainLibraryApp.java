package com.linkedlist.doublylinkedlist.librarymanagementsystem;

import java.util.Scanner;

public class MainLibraryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean status = sc.nextBoolean();

                    if (choice == 1)
                        library.addAtBeginning(id, title, author, genre, status);
                    else if (choice == 2)
                        library.addAtEnd(id, title, author, genre, status);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        library.addAtPosition(pos, id, title, author, genre, status);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Book ID to remove: ");
                    library.removeById(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter Title to search: ");
                    library.searchByTitle(sc.nextLine());
                }
                case 6 -> {
                    System.out.print("Enter Author to search: ");
                    library.searchByAuthor(sc.nextLine());
                }
                case 7 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Update Availability (true/false): ");
                    boolean status = sc.nextBoolean();
                    library.updateAvailability(id, status);
                }
                case 8 -> library.displayForward();
                case 9 -> library.displayReverse();
                case 10 -> System.out.println("Total Books: " + library.countBooks());
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}
