package testApp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.indocs_CIDS.o1generic.JDBC_Util;

public class Execute_GPS_trade_Queries {

	public static void main(String[] args) throws SQLException {

		String paybatid = null;
		String indocsno = null;
		
		

		ResultSet rs = JDBC_Util.resultQuery(
				"select paymentbatchid,batchreferenceno, * from tx_trade_paymentbatch where paymentreferenceno='sumit07'");

		while (rs.next()) {

			paybatid = rs.getString(1);
			indocsno = rs.getString(2);

			System.out.println(paybatid + indocsno);

		}
		
		
		
		String GPSreadyQuery="SELECT PB.batchreferenceno, PB.paymentbatchid\r\n"
								+ "	FROM tx_trade_paymentbatch PB \r\n"
								+ "	INNER JOIN tm_customer C ON C.customercode=PB.customercode\r\n"
								+ "	INNER JOIN tx_trade_paymentbatchutil PBU ON PB.paymentbatchid=PBU.paymentbatchid\r\n"
								+ "	INNER JOIN tm_customercurrency CU ON CU.customercode = C.customercode AND CU.debitaccount = PBU.account\r\n"
								+ "	WHERE PB.status='G' AND PB.utilstatus='A' AND PB.gpsstatus IS NULL\r\n"
								+ "	AND PB.batchreferenceno = '"+indocsno+"'";
		
		String GPSfileUpdateQuery="UPDATE tx_trade_paymentbatch SET status='P', gpsstatus='Y', gpsfilename = 'HPL_GPCSV_TESTSCRIPT.csv' \r\n" + 
									"	WHERE paymentbatchid = '"+paybatid+"'update TU SET TU.receiverinfo1 = '',TU.receiverinfo2 = '' ,TU.receiverinfo3 = '/INDOCS/IDSTD-00000218', TU.gpsstatus = 'P'\r\n" + 
									"	FROM tx_trade_paymentbatchutil TU\r\n" + 
									"	WHERE TU.paymentbatchid = '"+paybatid+"'";
		
		
		
		

		
//		JDBC_Util.closeConnection();

		// 1 --Query to check if trade paymentBatch is ready for GPS CSV file generation
		

		ResultSet rs2 = JDBC_Util.resultQuery(GPSreadyQuery);


		while (rs2.next()) {

			paybatid = rs2.getString(2);
			indocsno = rs2.getString(1);

			System.out.println("1 "+paybatid + indocsno);

		}
		
//		JDBC_Util.closeConnection();
		
		//2. --If above query return any row then execute following query to update the GPSCSV file generation 
		
		JDBC_Util.updateQuery(GPSfileUpdateQuery);
		
//		JDBC_Util.closeConnection();
		
		//3. --Query to get the trade paymentbatch id of the transaction for which ACK has to be udpated
		
		ResultSet rs3 = JDBC_Util.resultQuery("SELECT paymentbatchid from tx_trade_paymentbatch where paymentbatchid = '"+paybatid+"' AND status = 'P'");
		
		
		while (rs3.next()) {

			paybatid = rs3.getString(1);

			System.out.println("3 "+paybatid);

		}
//		JDBC_Util.closeConnection();
		
		//4. --Update trade payment batch funding Positive ACK+
		
		JDBC_Util.updateQuery("UPDATE TDU SET gpsstatus = '1', TDU.fxrate = 1.0\r\n" + 
				"	FROM tx_trade_paymentbatchutil TDU \r\n" + 
				"	INNER JOIN tx_trade_paymentbatch TD ON TDU.paymentbatchid = TD.paymentbatchid AND TDU.customercode = TD.customercode\r\n" + 
				"	WHERE TDU.paymentbatchid = '"+paybatid+"'AND TD.status = 'P'");
		
//		JDBC_Util.closeConnection();
		//5. --Update trade payment batch for the positive ACK +
		
		JDBC_Util.updateQuery("UPDATE TD SET TD.gpsstatus = '5', TD.fxrate = 1.0 , \r\n" + 
				"	TD.amountininr = CASE TD.dr_cr WHEN 'C' THEN TD.totalamount * 1.0 ELSE TD.totalamount END\r\n" + 
				"	FROM tx_trade_paymentbatch TD\r\n" + 
				"	INNER JOIN tx_trade_paymentbatchutil TDU ON TD.paymentbatchid = TDU.paymentbatchid AND TD.customercode = TDU.customercode\r\n" + 
				"	WHERE ISNULL(TD.gpsstatus,'') NOT IN ('1','2','4','5') AND TD.status = 'P'\r\n" + 
				"	AND TD.paymentbatchid = '"+paybatid+"'");
		
		System.out.println("all queries done");
		
		JDBC_Util.closeConnection();
	}

}
