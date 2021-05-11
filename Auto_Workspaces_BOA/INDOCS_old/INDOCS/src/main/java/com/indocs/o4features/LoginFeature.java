package com.indocs.o4features;

import org.openqa.selenium.WebDriver;

import com.indocs.o1generic.Driver;
import com.indocs.o1generic.ExcelUtilities;
import com.indocs.o2pageobjects.LoginPage;


public class LoginFeature {

	
	WebDriver driver;
	LoginPage lp;

	
	
	public LoginFeature( ) {
		
		this.driver=Driver.getDriver();
		lp = new LoginPage(driver);
		
	}
	
	
	public void validlogin(String compID, String userID, String pwd){
		
	
		lp.getCompId().sendKeys(compID);
		lp.getUserId().sendKeys(userID);
		lp.getPwd().sendKeys(pwd);
		lp.getLoginbtn().click();
		
	}
	
	
	
}
