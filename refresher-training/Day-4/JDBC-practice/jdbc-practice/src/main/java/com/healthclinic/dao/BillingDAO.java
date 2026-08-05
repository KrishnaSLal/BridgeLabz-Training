package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthclinic.db.DBConnection;

public class BillingDAO {

    public void deleteBill() {

        String deleteSql = "DELETE FROM billing WHERE bill_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteSql)) {

            ps.setInt(1, 5);

            int rows = ps.executeUpdate();

            System.out.println(rows + " row deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}