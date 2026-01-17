//9. ArtExpo – Sort Artists by Registration Time (Insertion Sort)
//Story: At an art exhibition, artists register throughout the day. The system continuously adds
//each entry and maintains a sorted list by registration time for booth assignment. Insertion Sort
//fits well due to the incremental nature.
//Key Concepts:
//● Real-time insertion
//● Nearly sorted data
//● Time-based ordering


package com.artexpo;
import java.util.Scanner;

public class MainArtExpo{
   public static void main(String[]args) {

	           Scanner sc = new Scanner(System.in);

	           System.out.print("Enter number of artists: ");
	           int n = sc.nextInt();
	           sc.nextLine();

	           Registration[] artists = new Registration[n];

	           for (int i = 0; i < n; i++) {
	               System.out.println("\nEnter details for Artist " + (i + 1));
	               System.out.print("Name: ");
	               String name = sc.nextLine();

	               System.out.print("Registration time (in minutes): ");
	               int time = sc.nextInt();
	               sc.nextLine();

	               artists[i] = new Registration(name, time);
	           }

	           // Sort by registration time taken in min
	           ArtExpoManager.insertionSort(artists);

	           System.out.println("\nArtists Sorted by Registration Time:");
	           for (Registration artist : artists) {
	               System.out.println(artist);
	           }

	           sc.close();
	           }

}