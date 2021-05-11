package com.indocs_CIDS.o3features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class INDOCS_Common_Features {

	
	WebDriver driver;
	INDOCS_CommonPage cpi;
	

	public INDOCS_Common_Features(WebDriver driver) {

		
		this.driver = driver;
		cpi = new INDOCS_CommonPage(driver);
		

	}
	
	
	public void hoverTradeProcess() {

		Actions act = new Actions(driver);
		act.moveToElement(cpi.getTradeprocessmenu()).build().perform();
	}
	
	public void hoverTreasuryProcess() {

		Actions act = new Actions(driver);
		act.moveToElement(cpi.getTreasuryProcessMenu()).build().perform();
	}
	
	public void hoverExport() {

		Actions act = new Actions(driver);
		act.moveToElement(cpi.getExportMenu()).build().perform();
	}
}
