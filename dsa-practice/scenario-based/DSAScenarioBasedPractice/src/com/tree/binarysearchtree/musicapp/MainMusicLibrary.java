//Story: Music App - Organize Songs by Track ID
//A music streaming app organizes tracks in a library using track IDs.
//Scenarios:
//● 🔹 Scenario 1: Search Track — Users want to search a song using track ID.
//● 🔹 Scenario 2: Insert New Track — Add new releases to the library.
//● 🔹 Scenario 3: Show Playlist Alphabetically — In-order traversal by song title.

package com.tree.binarysearchtree.musicapp;

import java.util.Scanner;

public class MainMusicLibrary {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MusicLibraryBST library = new MusicLibraryBST();
        int choice;

        do {
            System.out.println("\n===== Music App Library =====");
            System.out.println("1. Insert New Track");
            System.out.println("2. Search Track by ID");
            System.out.println("3. Show Playlist Alphabetically");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Track ID: ");
                    int trackID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Track Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Artist Name: ");
                    String artist = sc.nextLine();
                    library.insert(trackID, title, artist);
                    System.out.println("Track added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Track ID to search: ");
                    trackID = sc.nextInt();
                    Track t = library.search(trackID);
                    if (t != null)
                        System.out.println("Found - " + t.title + " by " + t.artist);
                    else
                        System.out.println("Track not found.");
                    break;

                case 3:
                    library.displayAlphabetically();
                    break;

                case 4:
                    System.out.println("Exiting Music App Library.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
