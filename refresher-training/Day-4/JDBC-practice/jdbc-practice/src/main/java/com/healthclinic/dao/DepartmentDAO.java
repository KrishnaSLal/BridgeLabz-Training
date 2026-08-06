package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Department;

public class DepartmentDAO {

    // Add Department
    public void addDepartment(Department department) {

        String sql = "INSERT INTO department(department_name) VALUES(?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, department.getDepartmentName());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Department Added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View All Departments
    public void viewDepartments() {

        String sql = "SELECT * FROM department";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println("Department ID   : " +rs.getInt("department_id"));
                System.out.println("Department Name : " +rs.getString("department_name"));
                System.out.println(" ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Department
    public void searchDepartment(int departmentId) {

        String sql = "SELECT * FROM department WHERE department_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, departmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Department ID   : "+ rs.getInt("department_id"));
                System.out.println("Department Name : "+ rs.getString("department_name"));

            } else {

                System.out.println("Department Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Update Department
    public void updateDepartment(int departmentId, String newName) {

        String sql =
                "UPDATE department SET department_name=? WHERE department_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, newName);
            ps.setInt(2, departmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Department Updated Successfully");

            } else {

                System.out.println("Department Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Delete Department
    public void deleteDepartment(int departmentId) {

        String sql = "DELETE FROM department WHERE department_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, departmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Department Deleted Successfully");

            } else {

                System.out.println("Department Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}