package com.indocs_CIDS.o3features;

import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_LoginPage;
public class CIDS_Login_Feature {

	
	public WebDriver driver;
	public CIDS_LoginPage lp;
	public CIDS_CommonPage cp;
	public seleniumlib slib;
	
	public CIDS_Login_Feature(WebDriver driver) {
		
		//this.driver=Driver.getDriver();
		this.driver=driver;
		lp = new CIDS_LoginPage(driver);
		cp=new CIDS_CommonPage (driver);
		slib=new seleniumlib(driver);
		
	}
	
	
	public void MakerLogin(){
		
		lp.getCompId().sendKeys(ConfigLib.getValue("compid"));
		lp.getUserId().sendKeys(ConfigLib.getValue("makeruserid"));
		lp.getPwd().sendKeys(ConfigLib.getValue("makerpwd"));
		lp.getLoginbtn().click();
		
		slib.loginwait();
	}
	
	
	public void checkerLogin(){
		
		lp.getCompId().sendKeys(ConfigLib.getValue("compid"));
		lp.getUserId().sendKeys(ConfigLib.getValue("checkeruserid"));
		lp.getPwd().sendKeys(ConfigLib.getValue("checkerpwd"));
		lp.getLoginbtn().click();
		
		slib.loginwait();
	}
	
}
