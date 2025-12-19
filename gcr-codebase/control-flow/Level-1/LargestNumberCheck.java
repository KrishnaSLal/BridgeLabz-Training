import java.util.Scanner;

public class LargestNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter third number: ");
        int number3 = input.nextInt();

        if (number1 > number2 && number1 > number3) {
            System.out.println("The first number the largest");
            
        } 
        else if (number2 > number1 && number2 > number3) {
            System.out.println("The second number is the largest");

        } 
        else {
         
            System.out.println("The third number is the largest");
        }

        input.close();
    }
}
