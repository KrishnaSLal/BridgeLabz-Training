package com.methodreferences.invoiceobjectcreation;

@FunctionalInterface
public interface InvoiceFactory {
    Invoice create(String transactionId);
}
