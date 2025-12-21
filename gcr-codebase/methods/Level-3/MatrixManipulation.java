import java.util.Scanner;

public class MatrixManipulation{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter rows for Matrix A: ");
        int r1 = input.nextInt();
        System.out.print("Enter columns for Matrix A: ");
        int c1 = input.nextInt();

        System.out.print("Enter rows for Matrix B: ");
        int r2 = input.nextInt();
        System.out.print("Enter columns for Matrix B: ");
        int c2 = input.nextInt();

        // Create random matrices
        int[][] A = createRandomMatrix(r1, c1);
        int[][] B = createRandomMatrix(r2, c2);

        // Display matrices
        System.out.println("\nMatrix A:");
        displayMatrix(A);

        System.out.println("\nMatrix B:");
        displayMatrix(B);

        // Addition and Subtraction (only if dimensions match)
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nA + B:");
            displayMatrix(addMatrices(A, B));

            System.out.println("\nA - B:");
            displayMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition and Subtraction not possible (dimension mismatch)");
        }

        // Multiplication (only if columns of A == rows of B)
        if (c1 == r2) {
            System.out.println("\nA × B:");
            displayMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication not possible (column-row mismatch)");
        }

        input.close();
    }

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 10); // 0 to 9
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}