import java.util.Scanner;

public class FactorialRecursion {

    // Function to take input from user
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a positive integer: ");
        return scanner.nextInt();
    }

    // Recursive function to calculate factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorial(n - 1); // recursive step
    }

    // Function to display result
    public static void displayResult(int num, long result) {
        System.out.println("Factorial Result: ");
        System.out.println("Number    : " + num);
        System.out.println("Factorial : " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Factorial Using Recursion: ");
        int num = getInput(scanner);

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(num);
            displayResult(num, result);
        }

        scanner.close();
    }
}