import java.util.Scanner;

public class CollinearPoints {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input coordinates
        System.out.print("Enter x1 y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        System.out.print("Enter x3 y3: ");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        // Check using slope method
        boolean slopeResult = isCollinearUsingSlope(x1, y1, x2, y2, x3, y3);

        // Check using area method
        boolean areaResult = isCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        // Display results
        System.out.println("Collinear using Slope Formula = " + slopeResult);
        System.out.println("Collinear using Area Formula = " + areaResult);

        input.close();
    }

    // Method to check collinearity using slope formula
    public static boolean isCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {

        //For vertical line case
        if ((x2 - x1) == 0 && (x3 - x2) == 0) {
            return true;
        }

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {

        double area = 0.5 * (x1 * (y2 - y3)
                           + x2 * (y3 - y1)
                           + x3 * (y1 - y2));

        return area == 0;
    }
}