package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_TRSRY_OpsReviewChkr_Approval_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_TRSRY_OpsReviewChkr_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRSRY_INDOCS_OpsRevieweChecker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	seleniumlib slib;
	INDOCS_TRSRY_OpsReviewChkr_Page orcpti;
	INDOCS_TRSRY_OpsReviewChkr_Approval_Page orcapti;

	public TRSRY_INDOCS_OpsRevieweChecker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		slib = new seleniumlib(driver);
		orcpti= new INDOCS_TRSRY_OpsReviewChkr_Page(driver);
		orcapti= new INDOCS_TRSRY_OpsReviewChkr_Approval_Page(driver);
		
	}

	public void verify_TRSRY_ops_Review_Checker() {

		String indrefno = TRSRY_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);

		slib.iWait(1);
		
		hpi.getTreasuryModule().click();
		cpif.hoverTreasuryProcess();
		cpi.getOpsReviewChkrMenuTRSRY().click();

		slib.scrrolldown();
		orcpti.getViewBtn().click();
		slib.visiblewait(orcpti.getSortdate());
		orcpti.getSortdate().click();
		
		String indocrefnoxpath="//td[contains(text(),'"+indrefno+"')]/following-sibling::td[5]/input";

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();
		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}
		
		slib.clickablewait(orcapti.getcomplinceCkBx());
		orcapti.getcomplinceCkBx().click();
		
		try {
			orcapti.getapprovebtn().click();
		} catch (Exception e) {
			orcapti.getapprovebtn().click();
		}
		

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();
		

	}
}
