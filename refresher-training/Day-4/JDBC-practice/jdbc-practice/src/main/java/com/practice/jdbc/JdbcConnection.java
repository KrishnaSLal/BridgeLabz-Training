package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcConnection {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/healthclinic_jdbc";
		String username = "root";
		String password = "root";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Database connected successfully");
			
			
//			String sql = "INSERT INTO doctor (doctor_name, speciality) VALUES(?,?)";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setString(1, "Aadhya");
//			ps.setString(2, "Anil");
//			ps.executeUpdate();
			
			
			
			
//			String sql = "UPDATE doctor SET speciality = ? WHERE doctor_name = ?";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setString(1, "Cardiology");
//			ps.setString(2, "Aadhya");
//			ps.executeUpdate();
			
			
			
			
//			String sql = "INSERT INTO doctor(doctor_name, speciality) VALUES(?,?)";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setString(1, "Athira");
//			ps.setString(2, "Neurology");
//			ps.executeUpdate();
//			
//			ps.setString(1, "Ananya");
//			ps.setString(2, "Dermatology");
//			ps.executeUpdate();
//			
//			System.out.println("doctor inserted successfully");
//			
			
			
			
//			String sql = "INSERT INTO patient(patient_name, doctor_id) VALUES (?,?)";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setString(1, "Aleena");
//			ps.setInt(2, 1);
//			ps.executeUpdate();
//			
//			
//			ps.setString(1, "Linda");
//			ps.setInt(2, 3);
//			ps.executeUpdate();
			
			
//			String sql = "SELECT * FROM doctor";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				
//				int id = rs.getInt("doctor_id");
//				String name = rs.getString("doctor_name");
//				String speciality = rs.getString("speciality");
//				
//				System.out.println(id + "|" + name + "|" + speciality);
//			}
//			rs.close();
			
//			
//			String sql = "DELETE FROM doctor WHERE doctor_id = ?";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setInt(1, 2);
//			ps.executeUpdate();
//			
			
			
//			String sql = "UPDATE patient SET doctor_id = ? WHERE patient_id = ?";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setInt(1, 1);
//			ps.setInt(2, 1);
//			ps.executeUpdate();
			
			String sql = "SELECT * FROM patient";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("patient_id");
				String name = rs.getString("patient_name");
				int id2 = rs.getInt("doctor_id");
				
				System.out.println(id + "|" + name +"|" + id2);
			
			
			}
			
			rs.close();
			ps.close();
 			connection.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	    
				
	}

}