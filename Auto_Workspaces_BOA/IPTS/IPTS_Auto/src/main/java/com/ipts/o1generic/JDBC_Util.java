package com.ipts.o1generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public  class JDBC_Util {
	
	private static Connection con=null;
	public static ResultSet rs=null;

	
	
	
// Creating connection	
	public static Connection getCon() {

		
			try {

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				System.out.println("1"+con);
				
				if (con == null) {
				con = DriverManager.getConnection("jdbc:sqlserver://FIPLOKDB;databaseName=IPTSINDIA_IDPMS_SIT", "boauser","FsTest@123");
				System.out.println("JDBC connection created");
				System.out.println("con is "+ con);

			}else {
				System.out.println("connection is already created");
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
			con=getCon();
			con.createStatement().executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
// 	GetResult Query
	
	public static ResultSet resultQuery(String query) {
		
		
		try {
			con=getCon();
			rs= con.createStatement().executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}

	
	
	
// Close Connection	
	public static void closeConnection() {
		
		if (con != null) {
		try {
			con.close();
			con=null;      // becuase close method only close the connection but con doen't become null
			System.out.println("JDBC connection closed");
			
			if (con != null) {
				con=null;
				System.out.println("JDBC connection not closed so con =null applied ");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("close con exception"+e.getMessage());
		}
	}
		}

	
// Close connection by inderjeet
	
	public void closeConnection_IsclosedCheck() {
		try {
			if (!con.isClosed()) {
				con.close();
				// con = null;
				System.out.println("JDBC connection closed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("close con exception" + e.getMessage());
		}
	}
	

}
