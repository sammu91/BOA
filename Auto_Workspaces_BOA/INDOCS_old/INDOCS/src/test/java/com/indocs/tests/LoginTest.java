package com.indocs.tests;

import org.testng.annotations.Test;
import com.indocs.o1generic.ConfigLib;



public class LoginTest extends BaseAbstractTest {

	

	
	@Test
	public void CreateTrade() {
		driver.get("http://10.1.20.116:8099/CIDS-TE/");
		
		lf.validlogin(ConfigLib.getValue("makercompid"), ConfigLib.getValue("makeruserid"), ConfigLib.getValue("makerpwd"));
		
	}
}
