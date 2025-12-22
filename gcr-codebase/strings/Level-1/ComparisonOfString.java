import java.util.Scanner;

public class ComparisonOfString{

    // Method to compare two strings using charAt()
    static boolean compareUsingCharAt(String s1, String s2) {

        // If lengths are different, strings cannot be equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter first string: ");
        String str1 = input.next();

        System.out.print("Enter second string: ");
        String str2 = input.next();

        //Compare using charAt()
        boolean charAtResult = compareUsingCharAt(str1, str2);

        //Compare using built-in equals()
        boolean equalsResult = str1.equals(str2);

        //Output
        System.out.println("\nResult using charAt(): " + charAtResult);
        System.out.println("Result using equals(): " + equalsResult);

        // Check if both results are the same
        if (charAtResult == equalsResult) {
            System.out.println("Both methods give the SAME result.");
        } else {
            System.out.println("Both methods give DIFFERENT results.");
        }

        input.close();
    }
}