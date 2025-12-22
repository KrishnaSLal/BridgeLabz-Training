import java.util.Scanner;

public class IllegalArgumentExceptionDemo{

    // Method to generate IllegalArgumentException
    public static void generateException(String str) {
        // start index is greater than end index
        System.out.println(str.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String str) {
        try {
            // start index is greater than end index
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Calling method that generates exception
        System.out.println("\nGenerating Exception:");
        generateException(input);   // Program stops here

        // This line will not execute unless above is commented
        System.out.println("\nHandling Exception:");
        handleException(input);

        scanner.close();
    }
}