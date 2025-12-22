import java.util.Scanner;

public class WordLength2DArray{

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // end of string
        }
        return count;
    }

    // Method to split text into words without using split()
    public static String[] splitWords(String text) {

        int length = findLength(text);
        int wordCount = 1;

        // Count words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        String word = "";

        // Extract words
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word = word + ch;
            } else {
                words[index++] = word;
                word = "";
            }
        }

        words[index] = word; // last word
        return words;
    }

    // Method to create 2D array of words and their lengths
    public static String[][] createWordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter complete text: ");
        String input = scanner.nextLine();

        // Splitting words
        String[] words = splitWords(input);

        // Creating 2D array
        String[][] wordLengthArray = createWordLengthArray(words);

        // Displaying result in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < wordLengthArray.length; i++) {
            String word = wordLengthArray[i][0];
            int length = Integer.parseInt(wordLengthArray[i][1]);
            System.out.println(word + "\t" + length);
        }

        scanner.close();
    }
}