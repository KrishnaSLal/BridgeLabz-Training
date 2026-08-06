package com.healthclinic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/healthclinic_app";
	private static final String user = "root";
	private static final String password = "root";
	
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void main(String[] args) {
		
        try (Connection con = getConnection()) {

            System.out.println("Connection Successful");

        } 
        catch (SQLException e) {

            e.printStackTrace();

        }

	}

}
