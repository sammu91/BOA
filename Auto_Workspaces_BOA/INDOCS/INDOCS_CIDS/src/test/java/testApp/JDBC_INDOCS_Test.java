package testApp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.indocs_CIDS.o1generic.JDBC_Util;

public class JDBC_INDOCS_Test {
	
	
	public static void main(String[] args) {
		
		String paymentbatchid=null;
		String indoc="20191224_000001";
		
		
		ResultSet rs = JDBC_Util.resultQuery("select paymentbatchid from tx_tdexp_paymentbatch where batchreferenceno='"+indoc+"'");
		
		try {
			while(rs.next()) {
				
				paymentbatchid = rs.getString(1);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(paymentbatchid);
		System.out.println("update tx_tdexp_document set documentid='7679' where paymentbatchid="+paymentbatchid);
		JDBC_Util.updateQuery("update tx_tdexp_document set documentid='7679' where paymentbatchid="+paymentbatchid);
		
	}

}
