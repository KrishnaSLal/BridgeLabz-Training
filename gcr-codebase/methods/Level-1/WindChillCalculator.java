import java.util.Scanner;

public class WindChillCalculator {

    // Method to calculate wind chill (windChill = 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * windSpeed^0.16)
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    //main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //User input
        System.out.print("Enter temperature in Fahrenheit(<=50): ");
        double temperature = input.nextDouble();

        System.out.print("Enter wind speed in mph(>=3): ");
        double windSpeed = input.nextDouble();

        //condition check
        if (temperature <= 50 && windSpeed >= 3) {
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.printf("Temperature: %.2f°F, Wind Speed: %.2f mph%n", temperature, windSpeed);
            System.out.printf("Calculated Wind Chill: %.2f°F%n", windChill);
        } else {
            System.out.println("Wind chill formula is not valid for these conditions.");
            System.out.printf("Temperature: %.2f°F, Wind Speed: %.2f mph%n", temperature, windSpeed);
        }

        input.close();
    }
}