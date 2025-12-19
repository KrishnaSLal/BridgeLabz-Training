import java.util.Scanner;

public class Power_Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the base number
        System.out.print("Enter a positive integer for the base number: ");
        int number = input.nextInt();

        // Get theexponent
        System.out.print("Enter a positive integer for the power: ");
        int power = input.nextInt();

        // Validate the input
        if (number <= 0 || power < 0) {
            System.out.println("Please enter positive integers (power can be 0).");
        } else {
            int result = 1; // Initialize result

            // Multiply number by itself 'power' times
            for (int i = 1; i <= power; i++) {
                result *= number;
            }

            System.out.println(number + " raised to the power " + power + " is: " + result);
        }

        input.close();
    }
}
