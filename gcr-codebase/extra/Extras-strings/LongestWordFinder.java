import java.util.Scanner;

public class LongestWordFinder{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Find longest word
        String longestWord = findLongestWord(sentence);

        // Output
        System.out.println("Longest word: " + longestWord);

        scanner.close();
    }

    // Method to find the longest word
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // split by spaces
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}