import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Toggle case
        String result = toggleCase(input);

        // Output
        System.out.println("Toggled string: " + result);

        scanner.close();
    }

    // Method to toggle case of characters
    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c); // non-alphabetic characters remain unchanged
            }
        }

        return sb.toString();
    }
}