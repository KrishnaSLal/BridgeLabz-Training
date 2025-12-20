import java.util.Scanner;

public class DigitFrequency{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //input for the number
        System.out.print("Enter a number: ");
        long number = input.nextLong();

        //Make a copy of number to count digits
        long workingNumber = number;

        //Find the count of digits
        int count = 0;
        while (workingNumber != 0) {
            count++;
            workingNumber /= 10;
        }

        //Create array to store digits
        int[] digits = new int[count];

        //Extract digits and store
        workingNumber = number;
        int index = 0;
        while (workingNumber != 0) {
            digits[index] = (int) (workingNumber % 10);
            workingNumber /= 10;
            index++;
        }

        //frequency array for digits 0–9
        int[] frequency = new int[10];

        //finding frequency of each digit
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        //Output
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time");
            }
        }

        input.close();
    }
}
