import java.util.Scanner;

public class SumNaturalNumbers {

    //method to calculate sum of n natural numbers using loop
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;  // add each number to sum
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter a positive integer n: ");
        int n = input.nextInt();

        // Call method and display result
        int result = findSum(n);
        System.out.println("Sum of first " + n + " natural numbers = " + result);

        input.close();
    }
}