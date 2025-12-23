import java.util.Scanner;

public class FirstNonRepeatingCharacter{

    // Method to find the first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {

        int[] frequency = new int[256]; // ASCII character count

        // Loop to count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Loop to find the first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // indicates no non-repeating character
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);
        
		//output
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
}