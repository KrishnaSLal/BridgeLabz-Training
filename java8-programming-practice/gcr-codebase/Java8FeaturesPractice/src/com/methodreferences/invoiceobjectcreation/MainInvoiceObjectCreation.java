//Invoice Object Creation
//○ Scenario: Generate invoice objects from transaction IDs.
//○ Task: Use a constructor reference.


package com.methodreferences.invoiceobjectcreation;

import java.util.*;

class Invoice {
    private String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}



public class MainInvoiceObjectCreation {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        // Constructor reference
        InvoiceFactory factory = Invoice::new;

        List<Invoice> invoices = transactionIds.stream().map(factory::create).toList();

        invoices.forEach(System.out::println);
    }
}

