import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sentence
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Input word to replace
        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();

        // Input new word
        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();

        // Replace word
        String result = replaceWord(sentence, oldWord, newWord);

        // Output
        System.out.println("Modified Sentence: " + result);

        scanner.close();
    }

    // Method to replace a word with another word
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split("\\s+"); // split by spaces
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                sb.append(newWord);
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}