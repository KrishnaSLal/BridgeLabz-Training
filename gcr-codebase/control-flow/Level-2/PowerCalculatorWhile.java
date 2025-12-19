import java.util.Scanner;

public class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get base number
        System.out.print("Enter a positive integer for the base number: ");
        int number = input.nextInt();

        // Get exponent
        System.out.print("Enter a positive integer for the power: ");
        int power = input.nextInt();

        // Validate input
        if (number <= 0 || power < 0) {
            System.out.println("Please enter a positive integer for the base and a non-negative integer for the power.");
        } else {
		    // Initialize result
            int result = 1;  
            // Initialize counter			
            int counter = 0;      

            // Multiplying the number to itself power times.
            while (counter < power) {
                result *= number;
                counter++;         
            }

            System.out.println(number + " raised to the power " + power + " is: " + result);
        }

        input.close();
    }
}
