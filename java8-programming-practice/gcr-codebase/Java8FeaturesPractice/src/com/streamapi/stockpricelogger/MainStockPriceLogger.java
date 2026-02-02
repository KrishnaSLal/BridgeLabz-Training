package com.streamapi.stockpricelogger;

import java.util.*;

public class MainStockPriceLogger {
    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(
                1520.50, 1518.75, 1532.10, 1540.00, 1525.60
        );

        // Print each stock price update
        stockPrices.stream()
                   .forEach(price ->
                       System.out.println("Live Stock Price: ₹" + price)
                   );
    }
}
