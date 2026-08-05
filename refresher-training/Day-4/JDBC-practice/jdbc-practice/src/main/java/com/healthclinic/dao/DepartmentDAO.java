package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.healthclinic.db.DBConnection;

public class DepartmentDAO {

    public void addDepartment() {

        String sql = "INSERT INTO department (department_name) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, "Pediatrics");

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {

                if (keys.next()) {

                    System.out.println(
                        "New department_id: " + keys.getInt(1)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}