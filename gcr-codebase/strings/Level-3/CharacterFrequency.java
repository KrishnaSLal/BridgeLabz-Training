import java.util.Scanner;

public class CharacterFrequency{

    //Method to find character frequencies and return as 2D array
    public static String[][] findCharacterFrequency(String text) {

        int[] frequency = new int[256]; // ASCII frequency array

        // Loop to count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Count number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] != 0) {
                uniqueCount++;
                frequency[text.charAt(i)] = 0; // mark as counted
            }
        }

        // Recalculate frequency (since we reset it above)
        frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Create 2D array to store characters and frequencies
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Store character and frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                index++;
                frequency[ch] = 0; // avoid duplicates
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] result = findCharacterFrequency(input);

        System.out.println("\nCharacter\tFrequency");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }

        scanner.close();
    }
}
