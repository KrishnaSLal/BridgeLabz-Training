package com.dbmsjdbc.jdbc.transactionmanagement;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String accountTable = "CREATE TABLE IF NOT EXISTS account (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "balance REAL NOT NULL" +
                ")";

        String transactionTable = "CREATE TABLE IF NOT EXISTS transaction_history (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "from_account INTEGER," +
                "to_account INTEGER," +
                "amount REAL," +
                "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            stmt.execute(accountTable);
            stmt.execute(transactionTable);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}