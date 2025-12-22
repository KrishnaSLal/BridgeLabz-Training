import java.util.Scanner;

public class UppercaseComparison{

    // Method to convert string to uppercase using ASCII logic
    public static String convertToUppercase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If lowercase letter, convert to uppercase
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
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
        String manualUpper = convertToUppercase(input);

        // Using built-in method
        String builtInUpper = input.toUpperCase();

        // Comparing both results
        boolean isSame = compareStrings(manualUpper, builtInUpper);

        // Display results
        System.out.println("\nManual Uppercase : " + manualUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Are both results same? " + isSame);

        scanner.close();
    }
}