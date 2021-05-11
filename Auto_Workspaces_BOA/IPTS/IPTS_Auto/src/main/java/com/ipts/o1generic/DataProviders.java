package com.ipts.o1generic;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider (name="IPTS_DATA")
	public static Object[][] getIPTSData()
	{
		Object data[][] = ExcelUtiil_Naveen.getTestData("IPTSData",ConfigLib.dirPath+"\\testdata\\IPTStestData.xlsx");
		return data;
	}

	
}
