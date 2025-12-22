import java.util.Scanner;

public class SplitTextComparison{

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
    public static String[] manualSplit(String text) {

        int length = findLength(text);
        int wordCount = 1;

        // Count number of words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store indexes of spaces
        int[] spaceIndex = new int[wordCount - 1];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }

        // Extract words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndex.length; i++) {
            words[i] = text.substring(start, spaceIndex[i]);
            start = spaceIndex[i] + 1;
        }

        words[wordCount - 1] = text.substring(start, length);

        return words;
    }

    // Method to compare two String arrays using charAt()
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {

            if (findLength(arr1[i]) != findLength(arr2[i])) {
                return false;
            }

            for (int j = 0; j < findLength(arr1[i]); j++) {
                if (arr1[i].charAt(j) != arr2[i].charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter complete text: ");
        String input = scanner.nextLine();

        // User-defined split
        String[] manualWords = manualSplit(input);

        // Built-in split
        String[] builtInWords = input.split(" ");

        // Compare both results
        boolean result = compareStringArrays(manualWords, builtInWords);

        // Display words
        System.out.println("\nWords using manual split:");
        for (String word : manualWords) {
            System.out.println(word);
        }

        System.out.println("\nWords using built-in split:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + result);

        scanner.close();
    }
}