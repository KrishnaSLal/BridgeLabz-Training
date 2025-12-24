import java.util.Scanner;

public class PrimeNumberChecker {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime
        }
        // Check divisibility up to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // divisible → not prime
            }
        }
        return true; // no divisors means prime
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prime Number Checker");
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Call the prime check function
        boolean result = isPrime(num);

        // Professional output
        System.out.println("Result");
        if (result) {
            System.out.println(num + " is a PRIME number.");
        } else {
            System.out.println(num + " is NOT a prime number.");
        }

        scanner.close();
    }
}