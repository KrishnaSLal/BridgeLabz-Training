package com.hashmapsandhashfunctions.twosumproblem;

	import java.util.Scanner;

	public class MainTwoSum {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter number of elements: ");
	        int n = scanner.nextInt();

	        int[] arr = new int[n];
	        System.out.println("Enter array elements:");
	        for (int i = 0; i < n; i++) {
	            arr[i] = scanner.nextInt();
	        }

	        System.out.print("Enter target sum: ");
	        int target = scanner.nextInt();

	        int[] result = TwoSumService.findTwoSum(arr, target);

	        if (result[0] == -1) {
	            System.out.println("No pair found.");
	        } else {
	            System.out.println("Pair found at indices: "
	                    + result[0] + " and " + result[1]);
	            System.out.println("Values: "
	                    + arr[result[0]] + " + " + arr[result[1]]);
	        }

	        scanner.close();
	    }
	}
