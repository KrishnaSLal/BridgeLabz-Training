import java.util.Scanner;

public class StringIndexOutOfBounds{

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String str) {
        // Accessing index beyond string length
        System.out.println("Character at invalid index: " + str.charAt(str.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String str) {
        try {
            // Accessing index beyond string length
            System.out.println("Character at invalid index: " + str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Calling method that generates exception
        System.out.println("\nGenerating Exception:");
        generateException(input);   // Program stops here due to exception

        // This line will not execute if exception is not handled
        System.out.println("\nHandling Exception:");
        handleException(input);

        scanner.close();
    }
}