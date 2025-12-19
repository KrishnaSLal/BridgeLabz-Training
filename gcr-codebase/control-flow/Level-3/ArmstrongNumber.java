import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Get input number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Step 2: Initialize variables
        int originalNumber = number; // store original value
        int sum = 0;

        // Step 3: Use while loop until originalNumber becomes 0
        while (originalNumber != 0) {

            // Step 4: Get the last digit
            int digit = originalNumber % 10;

            // Step 5: Find cube of the digit and add to sum
            sum = sum + (digit * digit * digit);

            // Step 6: Remove the last digit
            originalNumber = originalNumber / 10;
        }

        // Step 7: Check if sum is equal to the original number
        if (sum == number) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is not an Armstrong Number.");
        }

        input.close();
    }
}
