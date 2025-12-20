import java.util.Scanner;

public class HandshakeCalculator {

    //Method to calculate number of handshakes
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //input from user
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        //Calculate handshakes
        int handshakes = calculateHandshakes(numberOfStudents);

        //Output
        System.out.println("Maximum number of possible handshakes: " + handshakes);

        scanner.close();
    }
}
