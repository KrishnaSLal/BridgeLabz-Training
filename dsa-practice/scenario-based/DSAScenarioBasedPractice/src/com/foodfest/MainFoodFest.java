//FoodFest – Sorting Stalls by Customer Footfall (Merge Sort)
//Story: At a multi-day food festival, organizers track footfall at every stall each day. They collect
//daily logs from all zones (already sorted by count), and use Merge Sort to combine zone-wise
//data into a master list for performance evaluation.
//Concepts Involved:
//● Merge Sort
//● Combining multiple sorted datasets
//● Stability in data with equal values

package com.foodfest;

import java.util.Scanner;

public class MainFoodFest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of stalls: ");
		int numberOfStalls = sc.nextInt();
		Footfall[] stalls = new Footfall[numberOfStalls];
		sc.nextLine();

		for (int i = 0; i < numberOfStalls; i++) {
			System.out.println("Enter the stall name: " + (i + 1) + ":");
			String stallName = sc.nextLine();

			System.out.print("Enter footfall for stall: ");
			int count = sc.nextInt();
			sc.nextLine();
			
			stalls[i] = new Footfall(stallName, count);
		}

		PerformanceEvaluation performance = new PerformanceEvaluation();

		System.out.println("\nAfter sorting: ");

		performance.mergeSort(stalls, 0, stalls.length - 1);
		performance.display(stalls);

		sc.close();
	}
}
