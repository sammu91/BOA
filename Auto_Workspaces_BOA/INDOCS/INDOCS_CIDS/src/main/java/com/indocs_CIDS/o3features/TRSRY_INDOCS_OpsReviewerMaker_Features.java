package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_TRSRY_OpsReviewMkr_Approval_Page;
import com.indocs_CIDS.o2pageobjects.TRSRY_INDOCS_OpsReviewMkrMgmt_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRSRY_INDOCS_OpsReviewerMaker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	TRSRY_INDOCS_OpsReviewMkrMgmt_Page ormpti;
	INDOCS_TRSRY_OpsReviewMkr_Approval_Page ormapti;
	seleniumlib slib;
	
	public TRSRY_INDOCS_OpsReviewerMaker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		ormpti = new TRSRY_INDOCS_OpsReviewMkrMgmt_Page(driver);
		ormapti = new INDOCS_TRSRY_OpsReviewMkr_Approval_Page(driver);
		slib= new seleniumlib(driver);
	}

	public void verify_TRSRY_ops_Review_Maker() {

		
		String indrefno= TRSRY_CIDS_Paymentchecker_Feature.INDOCSrefno; 
		System.out.println(indrefno);
		
		slib.iWait(1);
		
		hpi.getTreasuryModule().click();
		cpif.hoverTreasuryProcess();
		cpi.getOpsReviewMkrmenuTRSRY().click();
		
		ormpti.getViewBtn().click();
		slib.visiblewait(ormpti.getSortdate());
		ormpti.getSortdate().click();
		
		String indocrefnoxpath="//td[contains(text(),'"+indrefno+"')]/following-sibling::td[5]/input";
		System.out.println("indocs path saved in string ");

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}
		
		slib.clickablewait(ormapti.getOfacField());
		
		ormapti.getOfacField().sendKeys("OFAC test party 1");
		ormapti.getSendAppbtn().click();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());
		
		slib.alertaccept();
		
		

	}
}
