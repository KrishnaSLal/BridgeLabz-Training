import java.util.Scanner;

public class Employee_Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter your years of service: ");
        int yearsOfService = scanner.nextInt();

        double bonus = 0;

        // Checking if the employee is eligible for the bonus
        if (yearsOfService > 5) {
            bonus = salary * 0.05; // 5% bonus
        }

        System.out.println("Bonus amount: " + bonus);

        scanner.close();
    }
}
