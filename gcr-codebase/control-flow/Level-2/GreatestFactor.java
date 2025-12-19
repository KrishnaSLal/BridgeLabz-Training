import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            int greatestFactor = 1; 

            // Loop from number-1 down to 1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break; // Helps to exit the loop after finding the largest factor
                }
            }

            System.out.println("The greatest factor of " + number + " besides itself is: " + greatestFactor);
        }

        input.close();
    }
}
