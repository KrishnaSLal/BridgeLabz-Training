import java.util.Scanner;

public class TrimSpaces{

    // Method to find start and end index after trimming spaces
    // Returns array: [startIndex, endIndex]
    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a string with spaces: ");
        String input = scanner.nextLine();

        // Finding trim indexes
        int[] indexes = findTrimIndexes(input);

        // Creating trimmed string manually
        String manualTrim = createSubstring(input, indexes[0], indexes[1]);

        // Built-in trim
        String builtInTrim = input.trim();

        // Comparing both results
        boolean isSame = compareStrings(manualTrim, builtInTrim);

        // Displaying results
        System.out.println("\nManual Trim Result  : [" + manualTrim + "]");
        System.out.println("Built-in Trim Result: [" + builtInTrim + "]");
        System.out.println("Are both results same? " + isSame);

        scanner.close();
    }
}