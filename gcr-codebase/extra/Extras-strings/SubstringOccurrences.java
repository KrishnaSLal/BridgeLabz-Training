import java.util.Scanner;

public class SubstringOccurrences{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search: ");
        String subString = scanner.nextLine();

        // Count occurrences
        int count = countOccurrences(mainString, subString);

        // Output
        System.out.println("The substring \"" + subString + "\" occurs " + count + " times in the string.");

        scanner.close();
    }

    // Method to count substring occurrences
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length(); // move past this occurrence
        }

        return count;
    }
}