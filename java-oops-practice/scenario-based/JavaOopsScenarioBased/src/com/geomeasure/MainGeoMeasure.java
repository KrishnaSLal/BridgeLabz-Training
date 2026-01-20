package com.geomeasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGeoMeasure {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Line> lineList = new ArrayList<>();

        System.out.print("Enter number of line comparisons: ");
        int comparisons = scanner.nextInt();

        for (int i = 1; i <= comparisons; i++) {
            System.out.println("\nEnter coordinates for Line " + (2*i - 1));
            Line line1 = createLine(scanner);

            System.out.println("Enter coordinates for Line " + (2*i));
            Line line2 = createLine(scanner);

            lineList.add(line1);
            lineList.add(line2);

            System.out.println("\nComparison Result:");
            LineComparator.compareLines(line1, line2);
        }

        System.out.println("\nTotal lines stored: " + lineList.size());
        scanner.close();
    }
    private static Line createLine(Scanner scanner) {
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();

        return new Line(x1, y1, x2, y2);
    }
}
