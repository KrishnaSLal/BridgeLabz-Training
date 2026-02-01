package com.interfaces.staticmethodsininterface.unitconversiontool;

import java.util.Scanner;

public class MainUnitConversion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        System.out.println("Miles: " + UnitConverter.kmToMiles(km));

        System.out.print("\nEnter weight in kilograms: ");
        double kg = sc.nextDouble();
        System.out.println("Pounds: " + UnitConverter.kgToPounds(kg));

        sc.close();
    }
}
