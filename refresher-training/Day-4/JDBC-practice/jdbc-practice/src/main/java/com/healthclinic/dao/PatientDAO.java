package com.healthclinic.dao;

import java.sql.*;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Patient;

public class PatientDAO {

    // Add Patient
    public void addPatient(Patient patient) {

        String sql = "INSERT INTO patient(name, phone, dob, gender) VALUES(?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setDate(3, patient.getDob());
            ps.setString(4, patient.getGender());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View All Patients
    public void viewPatients() {

        String sql = "SELECT * FROM patient";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("DOB        : " + rs.getDate("dob"));
                System.out.println("Gender     : " + rs.getString("gender"));
                System.out.println(" ");
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Patient
    public void searchPatient(int patientId) {

        String sql = "{CALL GetPatientById(?)}";

        try (
                Connection con = DBConnection.getConnection();
                CallableStatement cs = con.prepareCall(sql);
        ) {

            cs.setInt(1, patientId);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {

                System.out.println("Patient ID : " + rs.getInt("patient_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Phone      : " + rs.getString("phone"));
                System.out.println("DOB        : " + rs.getDate("dob"));
                System.out.println("Gender     : " + rs.getString("gender"));

            } else {

                System.out.println("Patient Not Found");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // Update Patient
    public void updatePatient(int patientId,String name,String phone,Date dob,String gender) {

    	String sql = "UPDATE patient SET name=?, phone=?, dob=?, gender=? WHERE patient_id=?";

    	try (
    			Connection con = DBConnection.getConnection();
    			PreparedStatement ps = con.prepareStatement(sql);
    			) {

    		ps.setString(1, name);
    		ps.setString(2, phone);
    		ps.setDate(3, dob);
    		ps.setString(4, gender);
    		ps.setInt(5, patientId);

    		int rows = ps.executeUpdate();

    		if(rows > 0)
    			System.out.println("Patient Updated Successfully");
    		else
    			System.out.println("Patient Not Found");

    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    // Delete Patient
    public void deletePatient(int patientId) {

        String sql = "DELETE FROM patient WHERE patient_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Patient Deleted Successfully");

            } else {

                System.out.println("Patient Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}