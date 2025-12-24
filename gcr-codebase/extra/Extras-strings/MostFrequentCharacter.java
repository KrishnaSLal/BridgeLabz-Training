import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find most frequent character
        char result = findMostFrequentChar(input);

        // Output
        System.out.println("Most Frequent Character: '" + result + "'");

        scanner.close();
    }

    // Method to find most frequent character
    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256]; // ASCII size
        int maxCount = 0;
        char mostFrequent = ' ';

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c]++;
            if (freq[c] > maxCount) {
                maxCount = freq[c];
                mostFrequent = c;
            }
        }

        return mostFrequent;
    }
}