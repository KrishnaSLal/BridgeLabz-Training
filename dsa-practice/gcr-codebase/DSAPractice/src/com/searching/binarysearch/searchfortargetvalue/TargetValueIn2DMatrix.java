package com.searching.binarysearch.searchfortargetvalue;

import java.util.Scanner;

public class TargetValueIn2DMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Take matrix input
        System.out.println("Enter matrix elements (row-wise sorted):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Take target value
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Search target
        boolean found = searchMatrix(matrix, rows, cols, target);

        // Output
        System.out.println("Target found: " + found);

        sc.close();
    }

    // Binary search in 2D matrix
    public static boolean searchMatrix(int[][] matrix, int rows, int cols, int target) {

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int r = mid / cols;
            int c = mid % cols;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
