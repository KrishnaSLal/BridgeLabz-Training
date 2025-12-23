import java.util.Scanner;

public class AnagramCheck{

    // Method to check if two texts are anagrams
    public static boolean isAnagram(String text1, String text2) {

        // Step 1: Check length
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Create frequency arrays (ASCII)
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Step 3: Find frequency of characters
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Step 4: Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();

        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();

        boolean result = isAnagram(text1, text2);

        if (result) {
            System.out.println("\nThe given texts are ANAGRAMS.");
        } else {
            System.out.println("\nThe given texts are NOT ANAGRAMS.");
        }

        scanner.close();
    }
}