import java.util.Scanner;

public class LowercaseComparison{

    // Method to convert string to lowercase using ASCII logic
    public static String convertToLowercase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If uppercase letter, convert to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }

            result = result + ch;
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

        // Taking complete text input
        System.out.print("Enter complete text: ");
        String input = scanner.nextLine();

        // Using user-defined method
        String manualLower = convertToLowercase(input);

        // Using built-in method
        String builtInLower = input.toLowerCase();

        // Comparing both results
        boolean isSame = compareStrings(manualLower, builtInLower);

        // Display results
        System.out.println("\nManual Lowercase : " + manualLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Are both results same? " + isSame);

        scanner.close();
    }
}