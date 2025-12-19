import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User input for countdown starting number.
        System.out.print("Enter the countdown starting number: ");
        int counter = input.nextInt();

        System.out.println("Countdown begins:");

        // While loop for countdown
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // Decrement counter
        }

        System.out.println("Launch");

        input.close();
    }
}
