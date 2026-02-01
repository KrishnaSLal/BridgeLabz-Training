//Digital Payment Interface
//○ Scenario: UPI, Credit Card, Wallet all must implement pay() method.
//○ Task: Define and implement.


package com.interfaces.implementinginterfaces.digitalpayment;

public class MainPayment {

    public static void main(String[] args) {

        Payment upi = new UPIPayment();
        Payment card = new CreditCardPayment();
        Payment wallet = new WalletPayment();

        upi.pay(500);
        card.pay(1200);
        wallet.pay(300);
    }
}
