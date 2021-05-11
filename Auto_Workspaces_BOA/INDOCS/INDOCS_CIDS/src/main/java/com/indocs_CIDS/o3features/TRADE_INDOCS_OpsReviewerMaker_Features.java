package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_OpsReviewMkr_Approval_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_OpsReviewmkr_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRADE_INDOCS_OpsReviewerMaker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	INDOCS_OpsReviewmkr_Page ormpi;
	INDOCS_OpsReviewMkr_Approval_Page ormapi;
	seleniumlib slib;
	
	public TRADE_INDOCS_OpsReviewerMaker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		ormpi = new INDOCS_OpsReviewmkr_Page(driver);
		ormapi = new INDOCS_OpsReviewMkr_Approval_Page(driver);
		slib= new seleniumlib(driver);
	}

	public void verify_ops_Review_Maker() {

		
		String indrefno=  TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno; 
		System.out.println(indrefno);
		
		slib.iWait(1);
		
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getOpsReviewMkrmenu().click();
		
		ormpi.getViewBtn().click();
		slib.visiblewait(ormpi.getSortdate());
		ormpi.getSortdate().click();
		
		
		
		String indocrefnoxpath="//td[contains(text(),'"+indrefno+"')]/following-sibling::td[5]/input";
		System.out.println("indocs path saved in string ");
		
//		//slib.clickablewait(driver.findElement(By.xpath("//td[contains(text(),'\"+indrefno+\"')]/following-sibling::td[5]")));
//		slib.clickablewait(ormpi.getSortdate());
		
		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}
		
		slib.clickablewait(ormapi.getOfacField());
		ormapi.getOfacField().sendKeys("OFAC test party 1");
		ormapi.getSendAppbtn().click();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());
		
		slib.alertaccept();
		
		

	}
}
