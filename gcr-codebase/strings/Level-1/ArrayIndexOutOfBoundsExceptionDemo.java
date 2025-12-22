import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        // Accessing index beyond array length
        System.out.println(names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            // Accessing index beyond array length
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking array size
        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Creating array
        String[] names = new String[size];

        // Taking names input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // Calling method that generates exception
        System.out.println("\nGenerating Exception:");
        generateException(names);   // Program stops here

        // This will not execute unless above line is commented
        System.out.println("\nHandling Exception:");
        handleException(names);

        scanner.close();
    }
}
