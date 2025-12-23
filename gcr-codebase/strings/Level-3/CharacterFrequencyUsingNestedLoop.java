import java.util.Scanner;

public class CharacterFrequencyUsingNestedLoop {

    // Method to find frequency of characters using nested loops
    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();   // store characters
        int[] freq = new int[chars.length];  // store frequency

        // Initialize frequency to 1
        for (int i = 0; i < freq.length; i++) {
            freq[i] = 1;
        }

        // Nested loops to calculate frequency
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {
                continue; // skip already counted characters
            }

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Count valid characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Create 1D String array to store result
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] result = findFrequency(input);

        System.out.println("\nCharacter Frequency:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}
