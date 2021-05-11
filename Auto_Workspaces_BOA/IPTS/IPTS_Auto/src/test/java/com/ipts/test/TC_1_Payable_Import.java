package com.ipts.test;

import org.testng.annotations.Test;

public class TC_1_Payable_Import extends BaseAbstractTest{
	
	@Test
	
	public void VerifyPayableImport() {
		
		lf.User1_Login();
		pif.PayableImport();
		
	}

}
