import java.util.Scanner;

public class Largest_SecondLargest_Digit {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        //Initial array size
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        //Store digits of the number
        while (number != 0) {

            //If array is full, increase size by 10
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] temp = new int[maxDigit];

                // Copy existing digits to temp array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                //Assign temp array to digits
                digits = temp;
            }

            //Extract last digit and store
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        //Variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Find largest and second largest digit
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display result
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        input.close();
    }
}
