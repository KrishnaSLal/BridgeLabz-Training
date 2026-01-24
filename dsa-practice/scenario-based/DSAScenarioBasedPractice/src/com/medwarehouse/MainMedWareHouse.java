package com.medwarehouse;

import java.util.Scanner;

public class MainMedWareHouse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of medicines: ");
        int n = sc.nextInt();

        Medicine[] medicines = new Medicine[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Medicine " + (i + 1));

            System.out.print("Medicine ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Medicine Name: ");
            String name = sc.nextLine();

            System.out.print("Days until Expiry: ");
            int days = sc.nextInt();

            medicines[i] = new Medicine(id, name, days);
        }

        MedicineRecords.mergeSort(medicines, 0, medicines.length - 1);

        System.out.println("\nMedicines Sorted by Expiry Date: ");
        for (Medicine med : medicines) {
            System.out.println(med);

            if (med.getExpiryDays() <= 7) {
                System.out.println("Expiry is near");
            }
        }

        sc.close();
    }
}
