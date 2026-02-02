//5. Logging Transactions
//Given a list of transaction IDs, use forEach() to log each transaction to the console with a
//timestamp.

package com.streamapi.loggingtransaction;

import java.time.LocalDateTime;
import java.util.*;

public class MainLoggingTransaction {
    public static void main(String[] args) {

        List<String> transactionIDs = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003",
                "TXN1004"
        );

        // Log each transaction with timestamp
        transactionIDs.forEach(txn -> 
            System.out.println(
                "Transaction ID: " + txn + " | Logged at: " + LocalDateTime.now()
            )
        );
    }
}
