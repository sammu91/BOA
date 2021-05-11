package com.indocs_CIDS.tests;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.DataProviders;

public class TC_3_ExportCycle extends BaseAbstractTest {

//CIDS	
	@Test(priority = 1, dataProvider = "initiateExport_DP", dataProviderClass = DataProviders.class)
	public void verify_Initiate_Export(String currency, String amount, String type, String buyer, String clientRefNo,
			String SBnum, String branch) {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.MakerLogin();
		ief.ExportMkr(currency, amount, type, buyer, clientRefNo, SBnum);

	}

	@Test(priority = 2, dependsOnMethods = "verify_Initiate_Export", dataProvider = "initiateExport_DP", dataProviderClass = DataProviders.class)
	public void verify_Approve_Export(String currency, String amount, String type, String buyer, String clientRefNo,
			String SBnumt, String branch) {

		driver.get(ConfigLib.getValue("cids_url"));
		lf.checkerLogin();
		ecf.approveExport(clientRefNo);
	}

	
	
	
//	 INDOCS
	@Test(priority = 3, dependsOnMethods = "verify_Approve_Export", dataProvider = "initiateExport_DP", dataProviderClass = DataProviders.class)

	public void verify_Ops_Review_Maker_EXPORT(String currency, String amount, String type, String buyer,
			String clientRefNo, String SBnumt, String branch) {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		eormfi.updateDocID();
		eormfi.verify_EXPORT_ops_Review_Maker(branch);

	}

	@Test(priority = 4, dependsOnMethods = "verify_Ops_Review_Maker_EXPORT")

	public void verify_Ops_Review_Checker_EXPORT() {

		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		eorcf.verify_EXPORT_ops_Review_Checker();

	}

}
