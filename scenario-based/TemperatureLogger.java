/*11. Temperature Logger 🌡️
Record temperatures over 7 days.
● Use array and for-loop.
● Find average and max temperature.
● Use if for comparisons. Maintain readable naming and modular code blocks.*/


import java.util.Scanner;

public class TemperatureLogger {

    // Constant for number of days
    private static final int DAYS = 7;

    public static void main(String[] args) {
        double[] temperatures = new double[DAYS];

        inputTemperatures(temperatures);
        double average = calculateAverage(temperatures);
        double maxTemperature = findMaxTemperature(temperatures);

        displayResults(average, maxTemperature);
    }

    // Method to take temperature input
    private static void inputTemperatures(double[] temperatures) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Enter temperature for Day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
        }
    }

    // Method to calculate average temperature
    private static double calculateAverage(double[] temperatures) {
        double sum = 0;

        for (double temp : temperatures) {
            sum += temp;
        }

        return sum / temperatures.length;
    }

    // Method to find maximum temperature
    private static double findMaxTemperature(double[] temperatures) {
        double max = temperatures[0];

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > max) {
                max = temperatures[i];
            }
        }

        return max;
    }

    // Method to display results
    private static void displayResults(double average, double maxTemperature) {
        System.out.println("Temperature Summary");
        System.out.println("Average Temperature: " + average + "°C");
        System.out.println("Maximum Temperature: " + maxTemperature + "°C");
    }
}