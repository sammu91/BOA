package o_03IAS.steps;

import org.openqa.selenium.WebDriver;

import o_02IAS.PageObjects.GlobalMasterPage;

public class GlobalMasterSteps {


	WebDriver driver;
	GlobalMasterPage gmp;
	
	
	public GlobalMasterSteps(WebDriver driver) {
		
		this.driver= driver;
		gmp= new GlobalMasterPage(driver);
	}
	
	
	
	public void click_Cis_Master() {
		
		gmp.getCIS_Masterlink().click();
	}
	
	
	public void click_CIS_Master_Checker() {
		
		gmp.getCIS_MasterCheckerlink().click();
	}
}
