import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int guess;
        int attempts = 0;
        int maxAttempts = 5;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have 5 attempts.\n");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > secretNumber) {
                System.out.println("Too high!");
            } else if (guess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                break;
            }

        } while (attempts < maxAttempts);

        if (guess != secretNumber) {
            System.out.println("Game Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        scanner.close();
    }
}
