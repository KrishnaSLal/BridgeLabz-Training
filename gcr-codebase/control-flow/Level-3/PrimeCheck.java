import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number greater than 1: ");
        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("Number should be greater than 1.");
        } else {
            boolean isPrime = true;  // Assume number is prime initially

            // Check divisibility from 2 up to number-1
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;  // Found a divisor, not prime
                    break;  // No need to check further
                }
            }

            if (isPrime) {
                System.out.println(number + " is a Prime Number.");
            } else {
                System.out.println(number + " is not a Prime Number.");
            }
        }

        input.close();
    }
}
