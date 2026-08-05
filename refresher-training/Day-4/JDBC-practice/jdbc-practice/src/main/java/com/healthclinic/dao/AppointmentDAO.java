package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.db.DBConnection;

public class AppointmentDAO {

    public void getScheduledAppointmentsByDoctor() {

        String sql = "SELECT * FROM appointment WHERE doctor_id = ? AND status = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, 1);
            ps.setString(2, "Scheduled");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    System.out.println(rs.getInt("appointment_id") + " | " + rs.getTimestamp("appointment_date"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}