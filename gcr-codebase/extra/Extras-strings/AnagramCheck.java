import java.util.Scanner;

public class AnagramCheck{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input strings
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // Normalize strings (ignore case and spaces)
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        // Check anagram
        if (isAnagram(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        scanner.close();
    }

    // Method to check if two strings are anagrams
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[256]; // ASCII character frequency

        // Count characters in first string
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }

        // Subtract counts using second string
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i)]--;
        }

        // If all counts are zero, strings are anagrams
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}