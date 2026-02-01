//Date Format Utility
//○ Scenario: An invoice generator must format dates in multiple formats.
//○ Task: Use a static interface method to format dates.


package com.interfaces.staticmethodsininterface.dateformatutility;

import java.time.LocalDate;
import java.util.Scanner;

public class MainInvoice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();

        LocalDate date = LocalDate.parse(inputDate);

        System.out.println("Invoice Date Formats:");
        System.out.println("DD-MM-YYYY : " +DateFormatUtils.formatDate(date, "dd-MM-yyyy"));
        System.out.println("MM/DD/YYYY : " +DateFormatUtils.formatDate(date, "MM/dd/yyyy"));
        System.out.println("YYYY/MM/DD : " +DateFormatUtils.formatDate(date, "yyyy/MM/dd"));

        sc.close();
    }
}
