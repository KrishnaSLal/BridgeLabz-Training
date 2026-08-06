package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Doctor;

public class DoctorDAO {

    // Add Doctor
    public void addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctor(name, specialty, department_id) VALUES(?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialty());
            ps.setInt(3, doctor.getDepartmentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View All Doctors
    public void viewDoctors() {

        String sql = "SELECT d.doctor_id, d.name, d.specialty, " +
                	 "dp.department_name " +
                	 "FROM doctor d " +
                	 "JOIN department dp " +
                	 "ON d.department_id = dp.department_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println("Doctor ID  : " + rs.getInt("doctor_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Specialty  : " + rs.getString("specialty"));
                System.out.println("Department : " + rs.getString("department_name"));
                System.out.println(" ");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Doctor
    public void searchDoctor(int doctorId) {

        String sql = "SELECT d.doctor_id, d.name, d.specialty, dp.department_name " +
                	 "FROM doctor d " +
                	 "JOIN department dp " +
                	 "ON d.department_id = dp.department_id " +
                	 "WHERE d.doctor_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Doctor ID  : " + rs.getInt("doctor_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Specialty  : " + rs.getString("specialty"));
                System.out.println("Department : " + rs.getString("department_name"));

            } else {

                System.out.println("Doctor Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Update Doctor
    public void updateDoctor(int doctorId,String name,String specialty,int departmentId) {

    	String sql = "UPDATE doctor SET name=?, specialty=?, department_id=? WHERE doctor_id=?";

    	try (
    			Connection con = DBConnection.getConnection();
    			PreparedStatement ps = con.prepareStatement(sql);
    		) {

    			ps.setString(1, name);
    			ps.setString(2, specialty);
    			ps.setInt(3, departmentId);
    			ps.setInt(4, doctorId);

    			int rows = ps.executeUpdate();

    			if(rows > 0)
    				System.out.println("Doctor Updated Successfully");
    			else
    				System.out.println("Doctor Not Found");

    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    // Delete Doctor
    public void deleteDoctor(int doctorId) {

        String sql = "DELETE FROM doctor WHERE doctor_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, doctorId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Doctor Deleted Successfully");

            } else {

                System.out.println("Doctor Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}