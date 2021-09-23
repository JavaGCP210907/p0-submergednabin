package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

		public static Connection getConnection() throws SQLException {
			
			try {
				Class.forName("org.postgresql.Driver");
				
			} catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=banking_app";
			String username = "postgres";
			String password = "password";
			
//			String url = System.getenv("URL");
//			String username = System.getenv("USERNAME");
//			String password = System.getenv("PASSWORD");
//			
			
			return DriverManager.getConnection(url,username, password);
			
		}
}
