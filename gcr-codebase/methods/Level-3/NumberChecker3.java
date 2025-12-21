import java.util.Scanner;

public class NumberChecker3{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Count digits and store digits in array
        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);

        // Display digits
        System.out.print("Digits array: ");
        displayArray(digits);

        // Reverse digits array
        int[] reversedDigits = reverseDigits(digits);

        System.out.print("Reversed digits array: ");
        displayArray(reversedDigits);

        // Compare original and reversed arrays
        boolean arraysEqual = compareArrays(digits, reversedDigits);
        System.out.println("Are digits array and reversed array equal? " + arraysEqual);

        // Check palindrome
        System.out.println("Is Palindrome Number = " + isPalindrome(digits, reversedDigits));

        // Check duck number
        System.out.println("Is Duck Number = " + isDuckNumber(digits));

        input.close();
    }

    // Method to find count of digits in a number
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store digits of a number in an array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to reverse the digits array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
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

    // Method to check if a number is palindrome using digits
    public static boolean isPalindrome(int[] digits, int[] reversedDigits) {
        return compareArrays(digits, reversedDigits);
    }

    // Method to check if a number is a duck number using digits array
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    //display array elements
    public static void displayArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
