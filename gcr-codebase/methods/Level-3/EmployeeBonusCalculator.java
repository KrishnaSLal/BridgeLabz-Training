public class EmployeeBonusCalculator {

    public static void main(String[] args) {

        // Get salary and years of service for employees
        double[][] employeeData = generateSalaryAndService();

        // Calculate new salary and bonus
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);

        // Display summary
        displaySalarySummary(employeeData, updatedData);
    }

    // Method to generate salary and years of service using Math.random()
    // Column 0 - Salary, Column 1 - Years of Service
    public static double[][] generateSalaryAndService() {
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000; // 5-digit salary
            data[i][1] = (int) (Math.random() * 10) + 1;       // Years of service (1–10)
        }
        return data;
    }

    // Method to calculate bonus and new salary
    // Column 0 - New Salary, Column 1 - Bonus Amount
    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] result = new double[10][2];

        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            result[i][0] = salary + bonus; // New Salary
            result[i][1] = bonus;          // Bonus Amount
        }
        return result;
    }

    // Method to calculate and display total salaries and bonuses
    public static void displaySalarySummary(double[][] oldData, double[][] newData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-5s %-12s %-8s %-12s %-12s%n", "Emp", "Old Salary", "Years", "Bonus", "New Salary");

        for (int i = 0; i < oldData.length; i++) {
            totalOldSalary += oldData[i][0];
            totalNewSalary += newData[i][0];
            totalBonus += newData[i][1];

            System.out.printf("%-5d %-12.2f %-8.0f %-12.2f %-12.2f%n", (i + 1), oldData[i][0], oldData[i][1],newData[i][1],newData[i][0]);
        }
		System.out.println("-------------------------------------------------");
        System.out.printf("%-5s %-12.2f %-8s %-12.2f %-12.2f%n", "Total", totalOldSalary, "", totalBonus, totalNewSalary);

    }
}
