package com.indocs_CIDS.o1generic;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider (name="initiatePaymentTrade_DP")
	public static Object[][] getTradeTestData()
	{
		Object data[][] = ExcelUtiil_Naveen.getTestData("TradeDataSheet",ConfigLib.dirPath+"\\testdata\\IN_CIDSTestDATA.xlsx");
		return data;
	}

	
	@DataProvider (name="initiatePaymentTRSRY_DP")
	public static Object[][] getTreasuryTestData()
	{
		Object data[][] = ExcelUtiil_Naveen.getTestData("TreasuryDataSheet",ConfigLib.dirPath+"\\testdata\\IN_CIDSTestDATA.xlsx");
		return data;
	}
	
	

	@DataProvider (name="initiateExport_DP")
	public static Object[][] getExportTestData()
	{
		Object data[][] = ExcelUtiil_Naveen.getTestData("ExportDataSheet",ConfigLib.dirPath+"\\testdata\\IN_CIDSTestDATA.xlsx");
		return data;
	}
}
