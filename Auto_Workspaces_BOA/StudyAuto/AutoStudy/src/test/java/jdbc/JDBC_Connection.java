package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {

	public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String USERNAME = "sumit";
	public static String PASSWORD = "Way2hell";
	public static String dbURL = "jdbc:sqlserver://FILT183;instance=SQLEXPRESS;databaseName=jdbc2";
	public static Connection con = null;

	// BOA URL: "jdbc:sqlserver://FIPLOKDB;databaseName="

	public static Connection getcon() throws SQLException, ClassNotFoundException {

		Class.forName(driverName);
		
		if (con == null) 
		{
			con = DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
		}
		
		return con;
}
}