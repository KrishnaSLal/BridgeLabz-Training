package com.dbmsjdbc.jdbc.transactionmanagement;

import java.sql.*;

public class BankingDAO {

    // Check Balance
    public void checkBalance(int accountId) {

        String sql = "SELECT balance FROM account WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Transfer Money (IMPORTANT PART)
    public void transferMoney(int fromId, int toId, double amount) {

        String withdrawSQL = "UPDATE account SET balance = balance - ? WHERE id=?";
        String depositSQL = "UPDATE account SET balance = balance + ? WHERE id=?";
        String historySQL = "INSERT INTO transaction_history(from_account, to_account, amount) VALUES(?,?,?)";

        Connection con = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);   // 🔥 Start Transaction

            // Withdraw
            PreparedStatement withdraw = con.prepareStatement(withdrawSQL);
            withdraw.setDouble(1, amount);
            withdraw.setInt(2, fromId);
            withdraw.executeUpdate();

            // Deposit
            PreparedStatement deposit = con.prepareStatement(depositSQL);
            deposit.setDouble(1, amount);
            deposit.setInt(2, toId);
            deposit.executeUpdate();

            // Save history
            PreparedStatement history = con.prepareStatement(historySQL);
            history.setInt(1, fromId);
            history.setInt(2, toId);
            history.setDouble(3, amount);
            history.executeUpdate();

            con.commit();   // ✅ Commit if everything successful
            System.out.println("Transfer Successful!");

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();  // ❌ Rollback if any error
                    System.out.println("Transaction Failed! Rolled Back.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // View Transaction History
    public void viewHistory() {

        String sql = "SELECT * FROM transaction_history";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "From: " + rs.getInt("from_account") +
                        " To: " + rs.getInt("to_account") +
                        " Amount: " + rs.getDouble("amount") +
                        " Date: " + rs.getString("date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}