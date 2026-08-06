package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthclinic.db.DBConnection;
import com.healthclinic.model.Billing;

public class BillingDAO {

    // Generate Bill
    public void generateBill(Billing billing) {

        String sql = "INSERT INTO billing(visit_id, amount, payment_status) VALUES(?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, billing.getVisitId());
            ps.setDouble(2, billing.getAmount());
            ps.setString(3, billing.getPaymentStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Bill Generated Successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void generateBill(Connection con, Billing bill) {

        String sql = "INSERT INTO billing(visit_id, amount, payment_status) VALUES(?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getVisitId());
            ps.setDouble(2, bill.getAmount());
            ps.setString(3, bill.getPaymentStatus());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Bill Generated Successfully");
            }

        } catch(SQLException e) {

            throw new RuntimeException(e);

        }

    }

    // View All Bills
    public void viewBills() {

        String sql ="SELECT b.bill_id, " +
                	"p.name AS patient_name, " +
                	"d.name AS doctor_name, " +
                	"b.amount, " +
                	"b.payment_status " +
                	"FROM billing b " +
                	"JOIN visit v ON b.visit_id = v.visit_id " +
                	"JOIN appointment a ON v.appointment_id = a.appointment_id " +
                	"JOIN patient p ON a.patient_id = p.patient_id " +
                	"JOIN doctor d ON a.doctor_id = d.doctor_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                System.out.println("Bill ID        : " + rs.getInt("bill_id"));
                System.out.println("Patient        : " + rs.getString("patient_name"));
                System.out.println("Doctor         : " + rs.getString("doctor_name"));
                System.out.println("Amount         : " + rs.getDouble("amount"));
                System.out.println("Payment Status : " + rs.getString("payment_status"));
                System.out.println(" ");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Search Bill
    public void searchBill(int billId) {

        String sql = "SELECT * FROM billing WHERE bill_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, billId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Bill ID        : " + rs.getInt("bill_id"));
                System.out.println("Visit ID       : " + rs.getInt("visit_id"));
                System.out.println("Amount         : " + rs.getDouble("amount"));
                System.out.println("Payment Status : " + rs.getString("payment_status"));

            } else {

                System.out.println("Bill Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Payment Status
    public void updateBill(int billId,int visitId,double amount,String paymentStatus) {

    	String sql = "UPDATE billing SET visit_id=?, amount=?, payment_status=? WHERE bill_id=?";

    	try (
    			Connection con = DBConnection.getConnection();
    			PreparedStatement ps = con.prepareStatement(sql);
    			) {

    		ps.setInt(1, visitId);
    		ps.setDouble(2, amount);
    		ps.setString(3, paymentStatus);
    		ps.setInt(4, billId);

    		int rows = ps.executeUpdate();

    		if(rows > 0)
    			System.out.println("Bill Updated Successfully");
    		else
    			System.out.println("Bill Not Found");

    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

    }

    // Delete Bill
    public void deleteBill(int billId) {

        String sql = "DELETE FROM billing WHERE bill_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, billId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Bill Deleted Successfully");

            } else {

                System.out.println("Bill Not Found");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}