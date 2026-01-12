package com.searching.binarysearch.searchfortargetvalue;

import java.util.Scanner;

public class TargetValueIn2DMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input matrix elements
        System.out.println("Enter matrix elements (row-wise sorted):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Input target
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Search
        boolean result = searchMatrix(matrix, rows, cols, target);

        // Output
        System.out.println("Target found: " + result);

        sc.close();
    }

    // Binary search method
    public static boolean searchMatrix(int[][] matrix, int rows, int cols, int target) {

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
