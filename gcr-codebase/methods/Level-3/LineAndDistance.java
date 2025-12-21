import java.util.Scanner;

public class LineAndDistance {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input for two points
        System.out.print("Enter x1 y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        // Method calls
        double distance = findDistance(x1, y1, x2, y2);
        double[] line = findLineEquation(x1, y1, x2, y2);

        // Results
        System.out.println("Euclidean Distance = " + distance);
        System.out.println("Equation of Line: y = " + line[0] + "x + " + line[1]);

        input.close();
    }

    // Method to find Euclidean distance between two points
    public static double findDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find slope and y-intercept of the line
    // Returns array where index 0 = slope (m), index 1 = y-intercept (b)
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];

        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;

        result[0] = m;
        result[1] = b;

        return result;
    }
}
