package com.indocs_CIDS.o3features;

import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o2pageobjects.INDOCS_LoginPage;

public class INDOCS_Login_Feature {
	
	
	WebDriver driver;
	INDOCS_LoginPage lpi;

	
	public INDOCS_Login_Feature(WebDriver driver) {
		
		this.driver=driver;
		lpi= new INDOCS_LoginPage(driver);
		
		
	}
	
	
	public void makerLogin_INODCS(){
	
		lpi.getUserCodeTxtfield().clear();
		lpi.getUserCodeTxtfield().sendKeys((ConfigLib.getValue("makeruserid_INDOCS")));
		lpi.getLoginbtn().click();
	
	}
	

	public void checkerLogin_INODCS(){
	
		lpi.getUserCodeTxtfield().clear();
		lpi.getUserCodeTxtfield().sendKeys((ConfigLib.getValue("checkeruserid_INDOCS")));
		lpi.getLoginbtn().click();
	
	}
	
	
}
