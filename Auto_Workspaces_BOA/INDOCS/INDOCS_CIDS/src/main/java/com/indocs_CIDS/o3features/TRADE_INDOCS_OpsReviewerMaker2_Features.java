package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_OpsReviewMkr_2_Approval_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_OpsReviewmkr_2_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRADE_INDOCS_OpsReviewerMaker2_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	seleniumlib slib;
	INDOCS_OpsReviewmkr_2_Page orm2pi;
	INDOCS_OpsReviewMkr_2_Approval_Page orma2pi;

	public TRADE_INDOCS_OpsReviewerMaker2_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		orma2pi = new INDOCS_OpsReviewMkr_2_Approval_Page(driver);
		slib = new seleniumlib(driver);
		orm2pi = new INDOCS_OpsReviewmkr_2_Page(driver);

	}

	public void verify_ops_Review_Maker2() {

		String indrefno = TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);


		slib.iWait(1);
		
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getOpsmaker2().click();

		orm2pi.getViewBtn().click();
		slib.visiblewait(orm2pi.getSortdate());
		orm2pi.getSortdate().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[5]/input";

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		orma2pi.getOfacField2().sendKeys("OFAC test party 1");
		orma2pi.getVerifyOFACbtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

		orma2pi.getSendAppbtn().click();

		slib.alertwait();
		slib.alertaccept();

	}
}
