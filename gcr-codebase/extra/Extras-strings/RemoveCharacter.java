import java.util.Scanner;

public class RemoveCharacter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Input character to remove
        System.out.print("Enter the character to remove: ");
        char ch = scanner.next().charAt(0);

        // Remove occurrences
        String result = removeCharacter(input, ch);

        // Output
        System.out.println("Modified String: \"" + result + "\"");

        scanner.close();
    }

    // Method to remove all occurrences of a character
    public static String removeCharacter(String str, char ch) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}