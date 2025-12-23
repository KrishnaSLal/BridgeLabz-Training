import java.util.Scanner;

public class CharacterType{

    // Method to check character type
    public static String checkCharacterType(char ch) {

        // Convert uppercase to lowercase (ASCII)
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        //Check alphabet
        if (ch >= 'a' && ch <= 'z') {

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to find vowels and consonants and store in 2D array
    public static String[][] findCharacterTypes(String text) {

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("\nCharacter\tType");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Processing characters
        String[][] characterTypes = findCharacterTypes(input);

        // Displaying result
        displayTable(characterTypes);

        scanner.close();
    }
}