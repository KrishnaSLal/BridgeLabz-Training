import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        int number = Integer.parseInt(text); // Exception if text is not numeric
        System.out.println("Number is: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking user input as String
        System.out.print("Enter a value: ");
        String input = scanner.nextLine();

        // Calling method that generates exception
        System.out.println("\nGenerating Exception:");
        generateException(input);   // Program stops here if input is non-numeric

        // This will not execute unless above line is commented
        System.out.println("\nHandling Exception:");
        handleException(input);

        scanner.close();
    }
}