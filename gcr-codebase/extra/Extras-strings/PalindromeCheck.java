import java.util.Scanner;

public class PalindromeCheck{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (optional: ignore case and spaces)
        String str = input.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome
        if (isPalindrome(str)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }

    // Method to check palindrome
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        return true; // no mismatch
    }
}