import java.util.Scanner;

public class FactorialCalculatorForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer (natural number): ");
        int number = input.nextInt();

        // Check if the input is a natural number
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number.");
        } else {
            double factorial = 1; 

            // Compute factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("The factorial of " + number + " is " + factorial);
        }

        input.close();
    }
}
