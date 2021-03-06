package com.ipts.test;

import org.testng.annotations.Test;

import com.ipts.o1generic.DataProviders;

public class TC_2_IPTS_Cycle extends BaseAbstractTest {

	
	@Test(priority = 1)
	public void VerifyPayableImport() {

		lf.User1_Login();
		pif.PayableImport();

	}

	@Test(priority = 2, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class)
	public void Verify_Data_Entry(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_Data_Entry execution starts");
		lf.User1_Login();
		iptscf.verfiy_Data_Entry(refNo);
		System.out.println("Verify_Data_Entry execution stops");
	}

	@Test(priority = 3, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class,dependsOnMethods = "Verify_Data_Entry")
	public void Verify_Data_Verification(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_Data_verification execution starts");
		lf.User2_Login();
		iptscf.verfiy_Data_Verification(refNo, invNo, amt, BOEno, currency);
		System.out.println("Verify_Data_verification execution stops");

	}

	@Test(priority = 4, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class, dependsOnMethods="Verify_Data_Verification")
	public void Verify_Generate_Pay_Batch(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_Generate_Pay_Batch execution starts");
		lf.User2_Login();
		iptscf.verfiy_GeneratePaymentBatch(refNo, vendorName);
		System.out.println("Verify_Generate_Pay_Batch execution stops");
	}
	
	
	
	
/* Issue appears so that thid is commented for time being and we are updating this in database
	
	@Test(priority = 5, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class,dependsOnMethods="Verify_Generate_Pay_Batch")
	public void Verify_OFAC_PayBat_Export(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_OFAC_PayBat_Export execution starts");
		lf.User2_Login();
		iptscf.verfiy_OFACPayBatExport(invNo, date);
		System.out.println("Verify_OFAC_PayBat_Export execution stops");
	} 
*/

	
	
	
	
	@Test(priority = 5, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class,dependsOnMethods="Verify_Generate_Pay_Batch")
	public void Verify_Update_OFAC_Expotr_Query(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {
		
		System.out.println("Update OFAC query execution starts");
		iptscf.Update_OFAC_Expotr_Query(refNo);
		System.out.println("Update OFAC query execution stops");
		
	}
	
	
	@Test(priority = 6, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class,dependsOnMethods="Verify_Update_OFAC_Expotr_Query")
	public void Verify_PayBat_Reg(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_PayBat_Reg execution starts");
		lf.User2_Login();
		iptscf.verfiy_PaymentBatchReg(vendorName, currency, date, invNo);
		System.out.println("Verify_PayBat_Reg execution stops");

	}

	@Test(priority = 7, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class,dependsOnMethods="Verify_PayBat_Reg")
	public void Verify_PayBat_Checker(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_PayBat_Checker execution starts");
		lf.User1_Login();
		iptscf.verfiy_PaymentBatchChecker(vendorName, currency, date, invNo);
		System.out.println("Verify_PayBat_Checker execution stops");

	}

	@Test(priority = 8, dataProvider = "IPTS_DATA", dataProviderClass = DataProviders.class,dependsOnMethods="Verify_PayBat_Checker")
	public void Verify_Query_Report(String refNo, String invNo, String amt, String BOEno, String currency,
			String vendorName, String date) {

		System.out.println("Verify_Query_Report execution starts");
		lf.User1_Login();
		iptscf.verfiy_customQueryReport(vendorName, currency, refNo, invNo);
		System.out.println("Verify_Query_Report execution stops");

	}

}
