package com.indocs_CIDS.o3features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;

public class CIDS_Common_Features {

	
	WebDriver driver;
	CIDS_CommonPage cp;
	

	public CIDS_Common_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		

	}
	
	
	public void hoverTrade() {

		Actions act = new Actions(driver);
		act.moveToElement(cp.getTradeMenu()).build().perform();
	}
	
	public void hoverTreasury() {

		Actions act = new Actions(driver);
		act.moveToElement(cp.getTreasuryMenu()).build().perform();
	}
	
	public void hoverExport() {

		Actions act = new Actions(driver);
		act.moveToElement(cp.getExportMenu()).build().perform();
	}
}
