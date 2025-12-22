import java.util.Scanner;

class LengthOfString{

    // Method to find string length without using length()
    static int findLengthWithoutLengthMethod(String text) {

        int count = 0;

        try {
            // Infinite loop
            while (true) {
                text.charAt(count); // Access character
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.next();

        // Length using user-defined method
        int customLength = findLengthWithoutLengthMethod(text);

        // Length using built-in method
        int builtInLength = text.length();

        // Display results
        System.out.println("\nLength without using length(): " + customLength);
        System.out.println("Length using length(): " + builtInLength);

        input.close();
    }
}
