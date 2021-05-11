package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_TRSRY_PaymentFundingChecker_Page;

public class TRSRY_CIDS_PaymentFundingChecker_Features {

	WebDriver driver;
	CIDS_Common_Features cf;
	CIDS_CommonPage cp;
	seleniumlib slib;
	CIDS_TRSRY_PaymentFundingChecker_Page pfcpt;

	public TRSRY_CIDS_PaymentFundingChecker_Features(WebDriver driver) {

		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		cf = new CIDS_Common_Features(driver);
		slib = new seleniumlib(driver);
		pfcpt = new CIDS_TRSRY_PaymentFundingChecker_Page(driver);

	}

	public void approve_TRSRY_PaymentFunding() {

		String indrefno= TRSRY_CIDS_Paymentchecker_Feature.INDOCSrefno; 
		System.out.println(indrefno);
		
		cf.hoverTreasury();
		cp.getPaymentFundingCheckerTRSRY().click();
		String indocrefnoxpath = "//td[contains(text(),'" + indrefno+ "')]/preceding-sibling::td[3]//input";
		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		
		pfcpt.getapproveBtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());
		slib.alertaccept();

	}

}
