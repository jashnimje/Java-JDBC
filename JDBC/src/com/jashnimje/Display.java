package com.jashnimje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Display {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "root";
		String password = "";
		String query = "SELECT * from records";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String dataSet = rs.getInt(1) + " : " + rs.getString(2) + "\t" + rs.getString(3) + "\t" +  rs.getLong(4) + "\t" + rs.getString(5);
				System.out.println(dataSet);
			}
			
			st.close();
			conn.close();
			
		} catch(Exception ex) {
			System.out.println("Error " + ex);
		}

	}

}
