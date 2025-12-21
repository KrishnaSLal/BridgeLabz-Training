import java.util.Scanner;

public class NumberChecker2{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Find count of digits and store digits in an array
        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);

        //Display digit count
        System.out.println("Count of digits = " + digitCount);

        //Display digits array
        System.out.print("Digits array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        //sum of digits
        int sum = sumOfDigits(digits);
        System.out.println("Sum of digits = " + sum);

        //sum of squares of digits
        double sumSquares = sumOfSquares(digits);
        System.out.println("Sum of squares of digits = " + sumSquares);

        // Check and display if the number is a Harshad number
        System.out.println("Is Harshad Number = " + isHarshadNumber(number, digits));

        //frequency of each digit
        int[][] frequency = digitFrequency(digits);
        System.out.println("Digit  Frequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "      " + frequency[i][1]);
            }
        }

        input.close();
    }

    // Method to find the count of digits in a number
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store the digits of the number in an array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to find the sum of digits using the digits array
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Method to find the sum of squares of digits using Math.pow()
    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // Method to check whether a number is a Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Method to find the frequency of each digit using a 2D array
    // First column stores digit, second column stores frequency
    public static int[][] digitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];

        // Initialize first column with digits 0 to 9
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }

        // Count frequency of each digit
        for (int d : digits) {
            frequency[d][1]++;
        }
        return frequency;
    }
}