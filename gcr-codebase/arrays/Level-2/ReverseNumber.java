import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int workingNumber = number; //For digit extraction
        int count = 0;

        //Count digits
        while (workingNumber != 0) {
            count++;
            workingNumber /= 10;
        }

        //Array to store digits in correct order
        int[] digits = new int[count];

        workingNumber = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = workingNumber % 10;
            workingNumber /= 10;
        }

        //Array to store reversed digits
        int[] reverseDigits = new int[count];

        for (int i = 0; i < count; i++) {
            reverseDigits[i] = digits[count - 1 - i];
        }

        //Output(Reverse)
        System.out.print("Reversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverseDigits[i]);
        }

        input.close();
    }
}

