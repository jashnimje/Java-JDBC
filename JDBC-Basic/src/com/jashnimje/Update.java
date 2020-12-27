package com.jashnimje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "root";
		String password = "";
		String query = "UPDATE records SET course = 'Python' where id = 3";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			int rs = st.executeUpdate(query);
			
			System.out.println(rs + " Row/s Affected ");
			
			st.close();
			conn.close();
			
		} catch(Exception ex) {
			System.out.println("Error " + ex);
		}

	}

}
