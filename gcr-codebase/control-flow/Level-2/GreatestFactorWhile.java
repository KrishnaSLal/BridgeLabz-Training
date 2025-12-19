import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            int greatestFactor = 1;
            int counter = number - 1;

            // Correct while loop without semicolon after condition
            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break;
                }
                counter--;
            }

            System.out.println("The greatest factor of " + number + " besides itself is: " + greatestFactor);
        }

        input.close();
    }
}
