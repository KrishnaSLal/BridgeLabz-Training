import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
		
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        //Initializing sum variable
        int sum = 0;

        //for loop from 1 - less than input number
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i; // Add divisor to sum
            }
        }

        //Checking if the sum of is greater than number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is Not an Abundant Number.");
        }

        input.close();
    }
}
