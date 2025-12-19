import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            System.out.println("Factors of " + number + " are:");

            // Initialize counter
            int counter = 1;

            // Loop using while
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++; // Increment counter
            }
        }

        input.close();
    }
}
