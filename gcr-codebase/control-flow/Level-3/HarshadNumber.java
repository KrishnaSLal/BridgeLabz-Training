import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();
        //Initializing original number and sum
        int originalNumber = number;
        int sum = 0;

        //while loop to extract digits
        while (originalNumber != 0) {
             
			// Get last digit
            int digit = originalNumber % 10; 
			// Add digit to sum
            sum = sum + digit;
            // Remove last digit			
            originalNumber = originalNumber / 10; 
        }

        //Checking if number is divisible by sum
        if (sum != 0 && number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is Not a Harshad Number.");
        }

        input.close();
    }
}
