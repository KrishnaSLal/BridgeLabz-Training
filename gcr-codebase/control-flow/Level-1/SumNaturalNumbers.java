import java.util.Scanner;
public class SumNaturalNumbers {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        // Check if the number is a natural number
        if (n >= 1) {
            // Compute sum using while loop
            int sumWhile = 0;
            int i = 1;
            while (i <= n) {
                sumWhile += i;
                i++;
            }

            // Compute sum using formula
            int sumFormula = n * (n + 1) / 2;

            // Display results
            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula: " + sumFormula);

            // Compare results
            if (sumWhile == sumFormula) {
                System.out.println("Both the computations are correct");
            } else {
                System.out.println("Both calculations are not equal.");
            }

        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        input.close();
      }
}
