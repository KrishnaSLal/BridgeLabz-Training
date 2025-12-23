import java.util.Scanner;

public class CountVowelsAndConsonants{

    // Method to check character type
    // Returns: 1 = Vowel, 2 = Consonant, 0 = Not a Letter
    public static int checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII logic
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if alphabet
        if (ch >= 'a' && ch <= 'z') {

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return 1; // Vowel
            } else {
                return 2; // Consonant
            }
        }

        return 0; // Not a letter
    }

    // Method to find vowels and consonants in a string
    // Returns array: [vowelCount, consonantCount]
    public static int[] countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            int result = checkCharacter(ch);

            if (result == 1) {
                vowels++;
            } else if (result == 2) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Counting vowels and consonants
        int[] counts = countVowelsAndConsonants(input);

        // Displaying result
        System.out.println("\nVowels Count     : " + counts[0]);
        System.out.println("Consonants Count : " + counts[1]);

        scanner.close();
    }
}