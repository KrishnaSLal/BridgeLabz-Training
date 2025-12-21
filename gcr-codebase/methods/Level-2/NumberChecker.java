import java.util.Scanner;

public class NumberChecker{

    // Method to check if number is positive
    public static boolean isPositive(int num) {
        return num >= 0;
    }

    // Method to check if number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array to store 5 numbers
        int[] numbers = new int[5];

        // Take user input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");
        // Loop through array and check each number
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println("Number " + num + " is Positive and Even.");
                } else {
                    System.out.println("Number " + num + " is Positive and Odd.");
                }
            } else {
                System.out.println("Number " + num + " is Negative.");
            }
        }

        // Comparing first and last element
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.println("\n--- Comparison of First and Last Element ---");
        if (result == 1) {
            System.out.println("First element (" + numbers[0] + ") is greater than Last element (" + numbers[4] + ")");
        } else if (result == 0) {
            System.out.println("First element (" + numbers[0] + ") is equal to Last element (" + numbers[4] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is less than Last element (" + numbers[4] + ")");
        }

        input.close();
    }
}