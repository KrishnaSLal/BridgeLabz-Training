import java.util.Scanner;

public class RemoveDuplicates{
    public static void main(String[] args) {
        Scanner scanner	= new Scanner(System.in);

        // Input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove duplicates
        String result = removeDuplicates(input);

        // Output
        System.out.println("Modified string (duplicates removed): " + result);

        scanner.close();
    }

    // Method to remove duplicate characters
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // Check if current character is already in result
            boolean found = false;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == current) {
                    found = true;
                    break;
                }
            }

            // If not found, append it
            if (!found) {
                sb.append(current);
            }
        }

        return sb.toString();
    }
}