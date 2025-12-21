import java.util.Scanner;

public class NumberChecker5{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Call methods and display results
        System.out.println("Is Perfect Number = " + isPerfect(number));
        System.out.println("Is Abundant Number = " + isAbundant(number));
        System.out.println("Is Deficient Number = " + isDeficient(number));
        System.out.println("Is Strong Number = " + isStrong(number));

        input.close();
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfect(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundant(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum > number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficient(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum < number;
    }

    // Method to check if a number is a strong number
    public static boolean isStrong(int number) {
        int temp = number;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    // Method to find factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }
}