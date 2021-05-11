package com.indocs_CIDS.o3features;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.indocs_CIDS.o1generic.JDBC_Util;

public class TRSRY_INDOCS_Execute_GPS_treasury_Queries {

	public static void create_TRSRY_GPSquery (String clientRefNo) {

		String paybatid = null;
		String indocsno = null;
		
		
		String getbatchidquery="select paymentbatchid,batchreferenceno, * from tx_trsry_paymentbatch where paymentreferenceno='"+clientRefNo+"'";
		

		ResultSet rs = JDBC_Util.resultQuery(getbatchidquery);

		try {
			
			
			while (rs.next()) {

				paybatid = rs.getString(1);
				indocsno = rs.getString(2);

				System.out.println(paybatid + indocsno);

			
		String GPSreadyQuery="SELECT PB.batchreferenceno, PB.paymentbatchid\r\n"
								+ "	FROM tx_trsry_paymentbatch PB \r\n"
								+ "	INNER JOIN tm_customer C ON C.customercode=PB.customercode\r\n"
								+ "	INNER JOIN tx_trsry_paymentbatchutil PBU ON PB.paymentbatchid=PBU.paymentbatchid\r\n"
								+ "	INNER JOIN tm_customercurrency CU ON CU.customercode = C.customercode AND CU.debitaccount = PBU.account\r\n"
								+ "	WHERE PB.status='G' AND PB.utilstatus='A' AND PB.gpsstatus IS NULL\r\n"
								+ "	AND PB.batchreferenceno = '"+indocsno+"'";
		
		String GPSfileUpdateQuery="UPDATE tx_trsry_paymentbatch SET status='P', gpsstatus='Y', gpsfilename = 'HPL_GPCSV_TESTSCRIPT.csv' \r\n" + 
									"	WHERE paymentbatchid = '"+paybatid+"'update TU SET TU.receiverinfo1 = '',TU.receiverinfo2 = '' ,TU.receiverinfo3 = '/INDOCS/IDSTD-00000218', TU.gpsstatus = 'P'\r\n" + 
									"	FROM tx_trsry_paymentbatchutil TU\r\n" + 
									"	WHERE TU.paymentbatchid = '"+paybatid+"'";
		
		
		
		
		

		
//		JDBC_Util.closeConnection();

		// 1 --Query to check if trade paymentBatch is ready for GPS CSV file generation
		

		ResultSet rs2 = JDBC_Util.resultQuery(GPSreadyQuery);


		while (rs2.next()) {

			paybatid = rs2.getString(2);
			indocsno = rs2.getString(1);

			System.out.println("1 "+paybatid + indocsno);

		}
		
		
		//2. --If above query return any row then execute following query to update the GPSCSV file generation 
		
		JDBC_Util.updateQuery(GPSfileUpdateQuery);
		
		
		//3. --Query to get the trade paymentbatch id of the transaction for which ACK has to be udpated
		
		ResultSet rs3 = JDBC_Util.resultQuery("SELECT paymentbatchid from tx_trsry_paymentbatch where paymentbatchid = '"+paybatid+"' AND status = 'P'");
		
		
		while (rs3.next()) {

			paybatid = rs3.getString(1);

			System.out.println("3 "+paybatid);

		}
		
		
		//4. --Update trade payment batch funding Positive ACK+
		
		JDBC_Util.updateQuery("UPDATE TRU SET gpsstatus = '1', TRU.fxrate = 1.0\r\n" + 
				"	FROM tx_trsry_paymentbatchutil TRU \r\n" + 
				"	INNER JOIN tx_trsry_paymentbatch TR ON TRU.paymentbatchid = TR.paymentbatchid AND TRU.customercode = TR.customercode\r\n" + 
				"	WHERE TRU.paymentbatchid = '"+paybatid+"'AND TR.status = 'P'");
		
		
		//5. --Update trade payment batch for the positive ACK +
		
		JDBC_Util.updateQuery("\r\n" + 
				"	UPDATE TR SET TR.gpsstatus = '1', TR.fxrate = 1.0 , \r\n" + 
				"	TR.amountininr = CASE TR.dr_cr WHEN 'C' THEN TR.totalamount * 1.0 ELSE TR.totalamount END\r\n" + 
				"	FROM tx_trsry_paymentbatch TR\r\n" + 
				"	INNER JOIN tx_trsry_paymentbatchutil TRU ON TR.paymentbatchid = TRU.paymentbatchid AND TR.customercode = TRU.customercode\r\n" + 
				"	WHERE TR.paymentbatchid = '"+paybatid+"' AND ISNULL(TR.gpsstatus,'') NOT IN ('1','2','4','5') AND TR.status = 'P'");
		
		
		
		System.out.println("all queries done");
		
		
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			JDBC_Util.closeConnection();
		}
	}

}
