package com.ipts.o3features;

import org.openqa.selenium.WebDriver;

import com.ipts.o1generic.ConfigLib;
import com.ipts.o1generic.seleniumlib;
import com.ipts.o2pageobjects.HomePage;
import com.ipts.o2pageobjects.LoginPage;

public class LoginFeatures {
	WebDriver driver;
	LoginPage lp;
	seleniumlib slib;
	HomePage hp;
	
	public LoginFeatures(WebDriver driver) {
		
		this.driver=driver;
		lp= new LoginPage(driver);
		slib = new seleniumlib(driver);
		hp= new HomePage(driver);
		
		
	}
	
	
	public void User1_Login(){
	
		lp.getUserCodeTxtfield().clear();
		lp.getUserCodeTxtfield().sendKeys((ConfigLib.getValue("user1")));
		lp.getLoginbtn().click();
		slib.selectdropdown(hp.getCustomerDrpDn(), ConfigLib.getValue("CutomerCode"));
		hp.getIPTS().click();
	
	}
	

	public void User2_Login(){
	
		lp.getUserCodeTxtfield().clear();
		lp.getUserCodeTxtfield().sendKeys((ConfigLib.getValue("user2")));
		lp.getLoginbtn().click();
		slib.selectdropdown(hp.getCustomerDrpDn(), ConfigLib.getValue("CutomerCode"));
		hp.getIPTS().click();
	
	}
	
	
}


