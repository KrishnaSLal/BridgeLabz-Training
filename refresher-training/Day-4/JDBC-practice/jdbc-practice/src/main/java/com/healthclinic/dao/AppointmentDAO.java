package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Appointment;

public class AppointmentDAO {

    // Schedule Appointment
    public void addAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointment(patient_id, doctor_id, appointment_date, status) VALUES(?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setTimestamp(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Appointment Scheduled Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View All Appointments
    public void viewAppointments() {

        String sql ="SELECT a.appointment_id, p.name AS patient_name, " +
                	"d.name AS doctor_name, a.appointment_date, a.status " +
                	"FROM appointment a " +
                	"JOIN patient p ON a.patient_id = p.patient_id " +
                	"JOIN doctor d ON a.doctor_id = d.doctor_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while(rs.next()) {

                System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Patient        : " + rs.getString("patient_name"));
                System.out.println("Doctor         : " + rs.getString("doctor_name"));
                System.out.println("Date & Time    : " + rs.getTimestamp("appointment_date"));
                System.out.println("Status         : " + rs.getString("status"));
                System.out.println(" ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Search Appointment
    public void searchAppointment(int appointmentId) {

        String sql = "SELECT a.appointment_id, " +
                     "p.name AS patient_name, " +
                     "d.name AS doctor_name, " +
                     "a.appointment_date, " +
                     "a.status " +
                     "FROM appointment a " +
                     "JOIN patient p ON a.patient_id = p.patient_id " +
                     "JOIN doctor d ON a.doctor_id = d.doctor_id " +
                     "WHERE a.appointment_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
                System.out.println("Patient        : " + rs.getString("patient_name"));
                System.out.println("Doctor         : " + rs.getString("doctor_name"));
                System.out.println("Date & Time    : " + rs.getTimestamp("appointment_date"));
                System.out.println("Status         : " + rs.getString("status"));

            } else {

                System.out.println("Appointment Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Status
    public void updateAppointment(int appointmentId,int patientId,int doctorId,Timestamp appointmentDate,String status) {

    	String sql = "UPDATE appointment SET patient_id=?, doctor_id=?, appointment_date=?, status=? WHERE appointment_id=?";

    	try (
    			Connection con = DBConnection.getConnection();
    			PreparedStatement ps = con.prepareStatement(sql);
    			) {

    		ps.setInt(1, patientId);
    		ps.setInt(2, doctorId);
    		ps.setTimestamp(3, appointmentDate);
    		ps.setString(4, status);
    		ps.setInt(5, appointmentId);

    		int rows = ps.executeUpdate();

    		if(rows > 0)
    			System.out.println("Appointment Updated Successfully");
    		else
    			System.out.println("Appointment Not Found");

    	} catch(SQLException e) {

    		e.printStackTrace();

    	}

    }

    // Delete Appointment
    public void deleteAppointment(int appointmentId) {

        String sql = "DELETE FROM appointment WHERE appointment_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, appointmentId);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Appointment Deleted Successfully");
            else
                System.out.println("Appointment Not Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}