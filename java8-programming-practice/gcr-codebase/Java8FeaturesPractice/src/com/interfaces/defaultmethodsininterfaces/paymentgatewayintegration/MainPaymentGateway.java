//Payment Gateway Integration
//○ Scenario: Multiple payment providers integrate with your app. A new refund
//method needs to be added without breaking old providers.
//○ Task: Add a default refund() method in the PaymentProcessor interface.


package com.interfaces.defaultmethodsininterfaces.paymentgatewayintegration;

import java.util.Scanner;

public class MainPaymentGateway {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PaymentProcessor gpay = new GPay();

        System.out.print("Enter payment amount: Rs. ");
        double payAmount = sc.nextDouble();
        gpay.processPayment(payAmount);

        System.out.print("Enter refund amount: Rs.");
        double refundAmount = sc.nextDouble();
        gpay.refund(refundAmount);   // default method

        sc.close();
    }
}

class GPay implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed via GPay.");
    }

}
