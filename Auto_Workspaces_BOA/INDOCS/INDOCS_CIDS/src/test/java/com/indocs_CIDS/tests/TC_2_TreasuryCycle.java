package com.indocs_CIDS.tests;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.DataProviders;
import com.indocs_CIDS.o3features.TRSRY_INDOCS_Execute_GPS_treasury_Queries;

public class TC_2_TreasuryCycle extends BaseAbstractTest {

	
	
// CIDS
	@Test(priority = 1, dataProvider = "initiatePaymentTRSRY_DP", dataProviderClass = DataProviders.class)
	public void verifyCreatePaymentTRSRY(String branch, String creditCurrency, String clientRefNo,
			String BeneficiaryCode, String amount, String invoiceCount, String purposeCode, String fundType,
			String custAccount) {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.MakerLogin();
		trf.addTrsPayment(branch, creditCurrency, clientRefNo, BeneficiaryCode, amount, invoiceCount, purposeCode);
		System.out.println("create payment stops");

	}

	@Test(priority = 2, dependsOnMethods = "verifyCreatePaymentTRSRY", dataProvider = "initiatePaymentTRSRY_DP", dataProviderClass = DataProviders.class)
	public void verifyApprovePaymentTRSRY(String branch, String creditCurrency, String clientRefNo,
			String BeneficiaryCode, String amount, String invoiceCount, String purposeCode, String fundType,
			String custAccount) {

		System.out.println("TRSRY approve payment run");
		driver.get(ConfigLib.getValue("cids_url"));
		lf.checkerLogin();
		pcft.approvePayment(clientRefNo);
		System.out.println("approve payment close");
	}

	
	
	// INDOCS
	@Test(priority = 3, dependsOnMethods = "verifyApprovePaymentTRSRY")

	public void verifyOpsReviewMakerTRSRY() {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		ormfti.verify_TRSRY_ops_Review_Maker();

	}


	@Test(priority = 4, dependsOnMethods = "verifyOpsReviewMakerTRSRY")

	public void verifyOpsReviewCheckerTRSRY() {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		orcfti.verify_TRSRY_ops_Review_Checker();

	}

	// CIDS

	@Test(priority = 5, dependsOnMethods = "verifyOpsReviewCheckerTRSRY", dataProvider = "initiatePaymentTRSRY_DP", dataProviderClass = DataProviders.class)

	public void verifyMakerPaymentFundingTRSRY(String branch, String creditCurrency, String clientRefNo,
			String BeneficiaryCode, String amount, String invoiceCount, String purposeCode, String fundType,
			String custAccount) {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.MakerLogin();
		pfmft.makePaymentFundingTRSRY(fundType, custAccount, amount);

	}

	@Test(priority = 6, dependsOnMethods = "verifyMakerPaymentFundingTRSRY")
	public void verify_TRSRY_PaymentFundingChkr() {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.checkerLogin();
		pfcft.approve_TRSRY_PaymentFunding();

	}

	
	
//GBS DB
	
	@Test(priority = 7, dependsOnMethods = "verify_TRSRY_PaymentFundingChkr", dataProvider = "initiatePaymentTRSRY_DP", dataProviderClass = DataProviders.class)

	public void creat_TRSRY_GPS(String branch, String creditCurrency, String clientRefNo,
			String BeneficiaryCode, String amount, String invoiceCount, String purposeCode, String fundType,
			String custAccount) {
		
		TRSRY_INDOCS_Execute_GPS_treasury_Queries.create_TRSRY_GPSquery(clientRefNo);
	}
	
	

	
	
// INDOCS	
	@Test(priority = 8,dependsOnMethods ="creat_TRSRY_GPS")
	public void Verify_TRSRY_Payment_Reg_Maker() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		tprmcfi.verify_TRSRY_PayReg_Maker();
		
	}
	@Test(priority = 9/*,dependsOnMethods ="Verify_TRSRY_Payment_Reg_Maker"*/)
	public void Verify_TRSRY_Payment_Reg_Checker() {
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		tprmcfi.verify_TRSRY_PayReg_Checker();
	}
	
	
	
}
