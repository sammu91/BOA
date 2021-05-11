package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_PaymentFundingChecker_Page;

public class TRADE_CIDS_PaymentFundingChecker_Features {

	WebDriver driver;
	CIDS_Common_Features cf;
	CIDS_CommonPage cp;
	seleniumlib slib;
	CIDS_PaymentFundingChecker_Page pfcp;

	public TRADE_CIDS_PaymentFundingChecker_Features(WebDriver driver) {

		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		cf = new CIDS_Common_Features(driver);
		slib = new seleniumlib(driver);
		pfcp = new CIDS_PaymentFundingChecker_Page(driver);

	}

	public void approvePaymentFunding() {

		cf.hoverTrade();
		cp.getPaymentFundingChecker().click();
		String indocrefnoxpath = "//td[contains(text(),'" + TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno
				+ "')]/preceding-sibling::td[3]/input";
		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		pfcp.getapproveBtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());
		slib.alertaccept();

	}

}
