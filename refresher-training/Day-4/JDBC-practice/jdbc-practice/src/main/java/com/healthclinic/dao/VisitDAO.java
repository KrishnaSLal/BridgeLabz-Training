package com.healthclinic.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Visit;

public class VisitDAO {

    // Add Visit
    public void addVisit(Visit visit) {

        String sql = "INSERT INTO visit(appointment_id, visit_date, diagnosis) VALUES(?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, visit.getAppointmentId());
            ps.setTimestamp(2, visit.getVisitDate());
            ps.setString(3, visit.getDiagnosis());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Visit Added Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Add visit for Transaction
    public void addVisit(Connection con, Visit visit) {

        String sql = "INSERT INTO visit(appointment_id, visit_date, diagnosis) VALUES(?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, visit.getAppointmentId());
            ps.setTimestamp(2, visit.getVisitDate());
            ps.setString(3, visit.getDiagnosis());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Visit Added Successfully");
            }

        } catch(SQLException e) {

            throw new RuntimeException(e);

        }
    }

    // View All Visits
    public void viewVisits() {

        String sql ="SELECT v.visit_id, p.name AS patient_name, " +
        			"d.name AS doctor_name, v.visit_date, v.diagnosis " +
        			"FROM visit v " +
        			"JOIN appointment a ON v.appointment_id = a.appointment_id " +
        			"JOIN patient p ON a.patient_id = p.patient_id " +
        			"JOIN doctor d ON a.doctor_id = d.doctor_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println("Visit ID   : " + rs.getInt("visit_id"));
                System.out.println("Patient    : " + rs.getString("patient_name"));
                System.out.println("Doctor     : " + rs.getString("doctor_name"));
                System.out.println("Visit Date : " + rs.getTimestamp("visit_date"));
                System.out.println("Diagnosis  : " + rs.getString("diagnosis"));
                System.out.println(" ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Visit
    public void searchVisit(int visitId) {

        String sql = "SELECT * FROM visit WHERE visit_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, visitId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Visit ID       : " + rs.getInt("visit_id"));
                System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Visit Date     : " + rs.getTimestamp("visit_date"));
                System.out.println("Diagnosis      : " + rs.getString("diagnosis"));

            } else {

                System.out.println("Visit Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Visit
    public void updateVisit(int visitId,int appointmentId,Timestamp visitDate,String diagnosis) {

    	String sql = "UPDATE visit SET appointment_id=?, visit_date=?, diagnosis=? WHERE visit_id=?";

    	try (
    			Connection con = DBConnection.getConnection();
    			PreparedStatement ps = con.prepareStatement(sql);
    			) {

    		ps.setInt(1, appointmentId);
    		ps.setTimestamp(2, visitDate);
    		ps.setString(3, diagnosis);
    		ps.setInt(4, visitId);

    		int rows = ps.executeUpdate();

    		if(rows > 0)
    			System.out.println("Visit Updated Successfully");
    		else
    			System.out.println("Visit Not Found");

    	} catch(SQLException e) {

    		e.printStackTrace();

    	}

    }

    // Delete Visit
    public void deleteVisit(int visitId) {

        String sql = "DELETE FROM visit WHERE visit_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, visitId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Visit Deleted Successfully");
            } else {
                System.out.println("Visit Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}