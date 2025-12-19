import java.util.Scanner;

public class EmployeeBonus{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter your years of service: ");
        int years = input.nextInt();

        double bonus = 0.0;

        // Checking if the employee is eligible for the bonus(bonus of 5% )
        if (years > 5) {
            bonus = salary * 0.05; 
        }

        System.out.println("The bonus amount is: " + bonus);

        input.close();
    }
}
