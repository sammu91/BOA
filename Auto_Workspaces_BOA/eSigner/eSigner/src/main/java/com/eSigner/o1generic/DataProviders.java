package com.eSigner.o1generic;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider (name="eSignerData")
	public static Object[][] getEsignerData()
	{
		Object data[][] = ExcelUtiil_Naveen.getTestData("Data",ConfigLib.dirPath+"\\testData\\eSignerTestData.xlsx");
		return data;
	}

	@DataProvider (name="eSignerUserData")
	public static Object[][] getUserData()
	{
		Object data[][] = ExcelUtiil_Naveen.getTestData("UserData",ConfigLib.dirPath+"\\testData\\eSignerTestData.xlsx");
		return data;
	}
}
