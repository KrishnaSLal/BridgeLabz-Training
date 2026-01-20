package com.geomeasure;

public class LineComparator {

    public static void compareLines(Line line1, Line line2) {

        double length1 = line1.calculateLength();
        double length2 = line2.calculateLength();

        System.out.println("Length of Line 1: " + length1);
        System.out.println("Length of Line 2: " + length2);

        if (Double.compare(length1, length2) == 0) {
            System.out.println("Both lines are of equal length.");
        } else if (length1 > length2) {
            System.out.println("Line 1 is longer than Line 2.");
        } else {
            System.out.println("Line 2 is longer than Line 1.");
        }
    }
}
