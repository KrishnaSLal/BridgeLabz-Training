package com.linkedlist.doublylinkedlist.moviemanagementsystem;

import java.util.Scanner;

public class MainMovieMangementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList movies = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies Forward");
            System.out.println("9. Display Movies Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Director: ");
                    String director = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("Rating: ");
                    double rating = sc.nextDouble();

                    if (choice == 1)
                        movies.addAtBeginning(title, director, year, rating);
                    else if (choice == 2)
                        movies.addAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Position: ");
                        movies.addAtPosition(title, director, year, rating, sc.nextInt());
                    }
                    break;

                case 4:
                    System.out.print("Enter Movie Title: ");
                    movies.removeByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Director Name: ");
                    movies.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Rating: ");
                    movies.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Movie Title: ");
                    String t = sc.nextLine();
                    System.out.print("New Rating: ");
                    movies.updateRating(t, sc.nextDouble());
                    break;

                case 8:
                    movies.displayForward();
                    break;

                case 9:
                    movies.displayReverse();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}
