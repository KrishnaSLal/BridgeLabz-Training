import java.util.Scanner;

public class MaximumOfThree {

    // Method to take integer input from user
    public static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Method to calculate maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Maximum of Three Numbers");

        // Taking inputs
        int num1 = getInput(scanner, "Enter first number: ");
        int num2 = getInput(scanner, "Enter second number: ");
        int num3 = getInput(scanner, "Enter third number: ");

        // Calculating maximum
        int max = findMaximum(num1, num2, num3);

        // Professional output
        System.out.println("Result:");
        System.out.println("Numbers entered : " + num1 + ", " + num2 + ", " + num3);
        System.out.println("Maximum number  : " + max);

        scanner.close();
    }
}