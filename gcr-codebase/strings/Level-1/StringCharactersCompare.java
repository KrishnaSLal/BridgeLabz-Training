import java.util.Scanner;

public class StringCharactersCompare{

    // creating a method to store characters in an array
    public static char[] getCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        return chars;
    }

    // creating method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = scanner.next();

        // User-defined method
        char[] manualChars = getCharacters(str);

        // Built-in method
        char[] builtInChars = str.toCharArray();

        // Compare results
        boolean result = compareCharArrays(manualChars, builtInChars);

        // Display characters
        System.out.print("\nCharacters using user-defined method: ");
        for (char c : manualChars) {
            System.out.print(c + " ");
        }

        System.out.print("\nCharacters using toCharArray(): ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }

        //output
        System.out.println("\n\nAre both character arrays equal? " + result);

        scanner.close();
    }
}