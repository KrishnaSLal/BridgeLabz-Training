import java.util.Scanner;

public class PalindromeChecker {

    // Function to take input from user
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine().trim();
    }

    // Function to check if the string is a palindrome
    public static boolean isPalindrome(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase(); // ignore spaces & case
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    // Function to display the result
    public static void displayResult(String text, boolean result) {
        System.out.println("\n--- Palindrome Check Result ---");
        if (result) {
            System.out.println("\"" + text + "\" is a PALINDROME.");
        } else {
            System.out.println("\"" + text + "\" is NOT a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker: ");
        String input = getInput(scanner);

        boolean result = isPalindrome(input);
        displayResult(input, result);

        scanner.close();
    }
}