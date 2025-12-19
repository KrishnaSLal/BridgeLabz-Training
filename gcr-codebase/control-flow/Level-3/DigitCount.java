import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Initializing count variable
        int count = 0;

        // Special case when number is 0
        if (number == 0) {
            count = 1;
        } else {

            // Loop until number becomes 0
            while (number != 0) {
				// for removing the last digit
                number = number / 10;
				
                count++;             
            }
        }

        System.out.println("Number of digits = " + count);

        input.close();
    }
}
