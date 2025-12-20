import java.util.Scanner;

public class NumberCheck{

    //Method to check the number
    public static int checkNumber(int num) {
        if (num > 0) {
            return 1;   // Positive
        } else if (num < 0) {
            return -1;  // Negative
        } else {
            return 0;   // Zero
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         
		//User input
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        int result = checkNumber(number);

        //Output
        if (result == 1) {
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        input.close();
    }
}