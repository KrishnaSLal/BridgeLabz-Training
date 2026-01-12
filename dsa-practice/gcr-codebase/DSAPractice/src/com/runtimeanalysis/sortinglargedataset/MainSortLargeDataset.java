package com.runtimeanalysis.sortinglargedataset;

import java.util.Scanner;

public class MainSortLargeDataset {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the count of numbers: ");
		int count = input.nextInt();
		int arr[] = new int[count];
		
		for(int i = 0; i<count; i++) {
			arr[i] = (int) ((Math.random() * count - 1) + 1);
		}
		int left = 0;
		int right = arr.length-1;
		input.close();
		
		long startBubble = System.nanoTime();
		BubbleSort.bubbleSort(arr);
		System.out.println("Array sorted using Bubble Sort");
		
		long endBubble = System.nanoTime();
		long totalBubble = endBubble-startBubble;
		System.out.println("Bubble sort Timing: " + totalBubble + " ms\n");
		
		long startMerge = System.nanoTime();
		MergeSort.mergeSort(arr, left, right);
		System.out.println("Array sorted using Merge Sort");
		
		long endMerge = System.nanoTime();
		long totalMerge = endMerge-startMerge;
		System.out.println("Merge sort Timing: " + totalMerge + " ms\n");
		
		long startQuick = System.nanoTime();
		QuickSort.partition(arr, left, right);
		System.out.println("Array sorted using Quick Sort");
		
		long endQuick = System.nanoTime();
		long totalQuick = endQuick-startQuick;
		System.out.println("Quick sort Timing: " + totalQuick + " ms");
	}
}