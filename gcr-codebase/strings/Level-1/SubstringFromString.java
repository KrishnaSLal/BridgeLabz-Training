import java.util.Scanner;

class SubstringFromString{

    //Method to create substring using charAt()
    static String substringUsingCharAt(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    //Method to compare two strings using charAt()
    static boolean compareStringsUsingCharAt(String s1, String s2) {

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

        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter the string: ");
        String text = input.nextLine();

        System.out.print("Enter start index: ");
        int start = input.nextInt();

        System.out.print("Enter end index: ");
        int end = input.nextInt();

        //Substring using charAt()
        String charAtSubstring = substringUsingCharAt(text, start, end);

        //Substring using built-in method
        String builtInSubstring = text.substring(start, end);

        //Compare both substrings
        boolean comparisonResult = compareStringsUsingCharAt(charAtSubstring, builtInSubstring);

        //Output
        System.out.println("\nSubstring using charAt(): " + charAtSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);

        if (comparisonResult) {
            System.out.println("Both substrings are EQUAL.");
        } else {
            System.out.println("Both substrings are NOT EQUAL.");
        }

        input.close();
    }
}
