package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.poi.util.SystemOutLogger;

public class Execute_Queries {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		executesql("CREATE TABLE Persons ( PersonID int,LastName varchar(255),FirstName varchar(255),"
				+ "Address varchar(255),City varchar(255));");
		
//		executesql("drop table Persons ");

	}

	public static void executesql(String query) {

		Connection con;
		try {
			con = JDBC_Connection.getcon();
			boolean flag;
			flag = con.createStatement().execute(query);
			System.out.println(flag);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
