import java.util.Scanner;

public class SumUntilZero {
     public static void main(String[] args) {
        
        double total = 0.0;
        double number;
		
		Scanner input = new Scanner(System.in);

        System.out.println("Enter numbers to sum (enter 0 to stop):");

        // First input from the user
        number = input.nextDouble();

        // While loop continues until the user enters 0
        while (number != 0) {
            total += number; // Add number to total
            number = input.nextDouble(); // Ask for next input
        }

        System.out.println("The total sum is: " + total);

        input.close();
    }
}
