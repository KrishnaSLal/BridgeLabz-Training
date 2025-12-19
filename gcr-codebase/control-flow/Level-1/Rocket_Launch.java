import java.util.Scanner;

public class Rocket_Launch {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User input for countdown starting number.
        System.out.print("Enter the countdown start number: ");
        int counter = input.nextInt();

        System.out.println("Countdown begins:");

        // For loop for countdown
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("LAUNCH");

        input.close();
    }
}
