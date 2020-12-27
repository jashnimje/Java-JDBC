package com.jashnimje;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	public static final String url = "jdbc:mysql://localhost:3306/slrtce";
	public static final String user = "root";
	public static final String pass = "jash123";
	
	public static Connection getConnection()
	{
		try {
			DriverManager.registerDriver(new Driver());
			System.out.println("Connection successful.");
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		}
		catch(SQLException ex)
		{
			throw new RuntimeException("Connection to the database failed.");
		}
	}
	public static void main(String args[])
	{
		Connection c= getConnection();
	}
}