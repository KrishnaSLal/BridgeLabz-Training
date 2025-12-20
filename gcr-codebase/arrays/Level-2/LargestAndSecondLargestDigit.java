import java.util.Scanner;

public class LargestAndSecondLargestDigit {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        //Array size for digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        //Extract digits and store in array
        while (number != 0 && index < maxDigit) {
            digits[index] = number % 10; // get last digit
            number = number / 10;         // remove last digit
            index++;
        }

        //Variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        //Find largest and second largest digit
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        //Output
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        input.close();
    }
}
