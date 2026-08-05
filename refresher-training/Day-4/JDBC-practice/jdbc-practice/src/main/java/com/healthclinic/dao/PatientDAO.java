package com.healthclinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthclinic.db.DBConnection;

public class PatientDAO {
	
	public void addPatient(){
		
		String sql = "INSERT INTO patient (name, phone, dob, gender) VALUES (?, ?, ?, ?)";
		
//		try(Connection conn = DBConnection.getConnection();
//				PreparedStatement ps = conn.prepareStatement(sql)){
//			
//			ps.setString(1, "Krishna");
//			ps.setString(2, "9999999999");
//			ps.setDate(3, java.sql.Date.valueOf("2003-07-25"));
//			ps.setString(4, "Female");
//			ps.executeUpdate();
//			
//			ps.setString(1, "Adithya");
//			ps.setString(2, "9987456321");
//			ps.setDate(3, java.sql.Date.valueOf("2002-03-03"));
//			ps.setString(4, "Female");
//			ps.executeUpdate();
//			
//			ps.setString(1, "Kiranjith");
//			ps.setString(2, "7896541230");
//			ps.setDate(3, java.sql.Date.valueOf("2002-05-14"));
//			ps.setString(4, "Male");
//			ps.executeUpdate();
//			
//			ps.setString(1, "Kashi");
//			ps.setString(2, "7854693210");
//			ps.setDate(3, java.sql.Date.valueOf("2000-08-05"));
//			ps.setString(4, "Female");
//			ps.executeUpdate();
//		    }
		
		
		String updateSql = "UPDATE patient SET phone = ? WHERE patient_id = ?";
		try (Connection conn = DBConnection.getConnection();
		     PreparedStatement ps = conn.prepareStatement(updateSql)) {
		    ps.setString(1, "9000011111");
		    ps.setInt(2, 1);
		    ps.executeUpdate();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	  }

}
