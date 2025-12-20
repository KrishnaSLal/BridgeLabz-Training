import java.util.Scanner;

public class TriangleParkRun{

    //Method to calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
		
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //taking user input
        System.out.print("Enter side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        //Calculate rounds
        double rounds = calculateRounds (side1, side2, side3 );
		int roundsInt = (int) Math.ceil(rounds);
          
        //Output
        System.out.println("Number of rounds required to complete 5 km: " + roundsInt);
       
        scanner.close();
    }
}
