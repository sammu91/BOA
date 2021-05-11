package com.eSigner.o1generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public  class JDBC_Util {
	
	public static Connection con=null;
	public static ResultSet rs=null;

	
	
	
// Creating connection	
	public static Connection getCon() {

		
			try {

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				System.out.println("1"+con);
				
				if (con == null) {
				con = DriverManager.getConnection("jdbc:sqlserver://FIPLOKDB;databaseName=INDOCS_DS", "boauser","FsTest@123");

			}
				} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
					e.printStackTrace();
				
			}
			
		return con;

	}

	
// Update query
	
	public static void updateQuery(String query) {
		
		
		try {
			getCon().createStatement().executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
// 	GetResult Query
	
	public static ResultSet resultQuery(String query) {
		
		
		try {
			rs= getCon().createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}

	
	
	
// Close Connection	
	public static void closeConnection() {
		
		try {
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
