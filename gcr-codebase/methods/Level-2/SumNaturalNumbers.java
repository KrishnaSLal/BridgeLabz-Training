import java.util.Scanner;

public class SumNaturalNumbers {

    // Recursive method to calculate sum of n natural numbers
    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;  // base case
        }
        return n + recursiveSum(n - 1);  // recursive step
    }

    // Formula method to calculate sum of n natural numbers
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter a natural number (positive integer): ");
        int n = input.nextInt();

        //Checking if valid natural number
        if (n <= 0) {
            System.out.println("Invalid input! Please enter a positive integer.");
        } else {
            //Calculate using recursion
            int sumRecursive = recursiveSum(n);

            //Calculate using formula
            int sumFormula = formulaSum(n);

            //Final output
            System.out.println("Number entered: " + n);
            System.out.println("Sum using recursion: " + sumRecursive);
            System.out.println("Sum using formula: " + sumFormula);

            //Comparison of the results 
            if (sumRecursive == sumFormula) {
                System.out.println("Both computation give the same result");
            } else {
                System.out.println("Results do not match");
            }
        }

        input.close();
    }
}