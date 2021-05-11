package com.indocs_CIDS.tests;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.DataProviders;
import com.indocs_CIDS.o3features.TRADE_INDOCS_Execute_GBS_trade_Queries;

public class TC_1_TradeCycle extends BaseAbstractTest {
	

	@Test(priority = 1, dataProvider = "initiatePaymentTrade_DP", dataProviderClass = DataProviders.class)
	public void verifyCreatePayment(String branch, String creditCurrency, String clientRefNo, String vendorCode,
			String amount, String invoiceCount, String fundType, String custAccount) {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.MakerLogin();
		tf.addpayment(branch, creditCurrency, clientRefNo, vendorCode, amount, invoiceCount);
		System.out.println("create payment stops");

	}

	@Test(priority = 2, dependsOnMethods = "verifyCreatePayment", dataProvider = "initiatePaymentTrade_DP", dataProviderClass = DataProviders.class)
	public void verifyApprovePayment(String branch, String creditCurrency, String clientRefNo, String vendorCode,
			String amount, String invoiceCount, String fundType, String custAccount) {

		System.out.println("approve payment run");
		driver.get(ConfigLib.getValue("cids_url"));
		lf.checkerLogin();
		pcf.approvePayment(clientRefNo);
		System.out.println("approve payment close");
	}





	// INDOCS
	@Test(priority = 3,dependsOnMethods = "verifyApprovePayment")

	public void verifyOpsReviewMakerTest() {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		ormfi.verify_ops_Review_Maker();

	}

	@Test(priority = 4, dependsOnMethods = "verifyOpsReviewMakerTest") // (dependsOnGroups="Trade_Approve_paymentGroup")

	public void verifyOpsReviewMaker2Test() {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		orm2fi.verify_ops_Review_Maker2();

	}

	@Test(priority = 5, dependsOnMethods = "verifyOpsReviewMaker2Test") // (dependsOnGroups="Trade_Approve_paymentGroup")

	public void verifyOpsReviewChecker() {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		orcfi.verify_ops_Review_Checker();
	}




	
	

	// CIDS

	@Test(priority = 6, dependsOnMethods = "verifyOpsReviewChecker", dataProvider = "initiatePaymentTrade_DP", dataProviderClass = DataProviders.class)
	public void verifyMakerPaymentFunding(String branch, String creditCurrency, String clientRefNo, String vendorCode,
			String amount, String invoiceCount, String fundType, String custAccount) {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.MakerLogin();
		pfmf.makePaymentFunding(fundType, custAccount, amount);

	}

	@Test(priority = 7, dependsOnMethods = "verifyMakerPaymentFunding")
	public void verifyCheckerPaymentFunding() {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.checkerLogin();
		pfcf.approvePaymentFunding();

	}
	
	
	
	

	
// GBS updation through DB	
	
	@Test(priority = 8,dependsOnMethods = "verifyCheckerPaymentFunding",dataProvider = "initiatePaymentTrade_DP", dataProviderClass = DataProviders.class)
	public void creat_Trade_GPS(String branch, String creditCurrency, String clientRefNo, String vendorCode,
			String amount, String invoiceCount, String fundType, String custAccount) {
		
		TRADE_INDOCS_Execute_GBS_trade_Queries.create_TRADE_GPSquery(clientRefNo);
		
	}
	
	
	
	
	
	

// Indocs	
	
	@Test(priority = 9,dependsOnMethods ="creat_Trade_GPS")
	public void Verify_SDS_Maker() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		spmfi.sds_Maker();
		
	}

	@Test(priority = 10,dependsOnMethods ="Verify_SDS_Maker")
	public void Verify_SDS_Checker() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		spacfi.sds_Checker();
	}
	
	@Test(priority = 11,dependsOnMethods ="Verify_SDS_Checker")
	public void Verify_Aries_Cancelation() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		spacfi.aries_Cancel_Checker();
	}
	
	
	@Test(priority = 12,dependsOnMethods ="Verify_Aries_Cancelation")
	public void Verify_Payment_Reg_Maker() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		prmcfi.verify_PayReg_Maker();
	}
	
	
	
	@Test(priority = 13,dependsOnMethods ="Verify_Payment_Reg_Maker")
	public void Verify_Payment_Reg_Checker() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		prmcfi.verify_PayReg_Checker();
	}
	
	
}




