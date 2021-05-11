package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_OpsReviewChkr_Approval_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_OpsReviewChkr_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRADE_INDOCS_OpsReviewChkr_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	seleniumlib slib;
	INDOCS_OpsReviewChkr_Page orcpi;
	INDOCS_OpsReviewChkr_Approval_Page orcapi;

	public TRADE_INDOCS_OpsReviewChkr_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		slib = new seleniumlib(driver);
		orcpi = new INDOCS_OpsReviewChkr_Page(driver);
		orcapi = new INDOCS_OpsReviewChkr_Approval_Page(driver);

	}

	public void verify_ops_Review_Checker() {

		String indrefno = TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);

		slib.iWait(1);

		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getOpsReviewChkrMenu().click();

		orcpi.getViewBtn().click();
		slib.visiblewait(orcpi.getSortdate());
		orcpi.getSortdate().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[5]/input";

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		slib.clickablewait(orcapi.getcomplinceCkBx());
		orcapi.getcomplinceCkBx().click();
		
		try {
			slib.clickablewait(orcapi.getapprovebtn());
			orcapi.getapprovebtn().click();
		} catch (Exception e) {
			slib.clickablewait(orcapi.getapprovebtn());
			orcapi.getapprovebtn().click();
			System.out.println("Catch worked for approve btn");
		}
		

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}
}
