package testApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Execute_Queries {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Connection	con = JDBC_Connection.getcon();
		ResultSet rs = con.createStatement().executeQuery("select * from tx_tdexp_paymentbatch where paymentreferenceno ='ref786'");
		
		
		
		while(rs.next()) {
			
			
			System.out.println("Data is : "+rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3) );
		}
		
		con.close();
	}

	
	
//	
//	public static void executesql(String query) {
//
//		Connection con;
//		try {
//			con = JDBC_Connection.getcon();
//			boolean flag;
//			flag = con.createStatement().execute(query);
//			System.out.println(flag);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//	}

}
