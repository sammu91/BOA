package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_TRSRY_InitiatePaymentPage;
import com.indocs_CIDS.o2pageobjects.CIDS_TRSRY_InitiateMgtPage;

public class TRSRY_CIDS_InitiatePaymentMaker_Features {

	WebDriver driver;
	CIDS_CommonPage cp;
	CIDS_TRSRY_InitiateMgtPage ippt;
	CIDS_TRSRY_InitiatePaymentPage appt;
	seleniumlib slib;
	CIDS_Common_Features cf;

	public TRSRY_CIDS_InitiatePaymentMaker_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		ippt = new CIDS_TRSRY_InitiateMgtPage(driver);
		appt = new CIDS_TRSRY_InitiatePaymentPage(driver);
		slib = new seleniumlib(driver);
		cf = new CIDS_Common_Features(driver);

	}

	public void addTrsPayment(String branch, String creditCurrency, String clientRefNo, String BeneficiaryCode,
			String amount, String invoiceCount, String purposeCode) {
		cf.hoverTreasury();
		
		cp.getInitiatePaymentTRSRY().click();
		
		slib.clickablewait(ippt.getAddbtn());

		ippt.getAddbtn().click();

		slib.clickablewait(appt.getSelBranch());
		slib.selectdropdown(appt.getSelBranch(), branch);

		slib.progresswait();

		slib.selectdropdown(appt.getSelCreditCurrency(), creditCurrency);

		appt.getClientref().sendKeys(clientRefNo);
		slib.selectdropdown(appt.getSelBeneficiaryCode(), BeneficiaryCode);
		slib.progresswait();

		appt.getCreditAmtfield().sendKeys(amount);

		appt.getInvoiceCountfield().sendKeys(invoiceCount);
		slib.selectdropdown(appt.getSelPurposeCode(), purposeCode);
		appt.getSavebtn().click();

		slib.progresswait();

		// confirm logic if payment already there

		if (slib.isElementPresent(appt.getConfirmBtn())) {

			appt.getConfirmBtn().click();
			slib.progresswait();
		}

		appt.getBrowsedoc().sendKeys(ConfigLib.dirPath + "\\testdata\\Holiday List -2019 Delhi NCR.pdf");
		appt.getUploaddoc().click();

		slib.alertwait();
		slib.alertaccept();
		appt.getInvoiceCkbx().click();
		appt.getBOECkbx().click();
		appt.getSendbtn().click();
		slib.alertwait();
		slib.alertaccept();

		slib.selectdropdown(ippt.getStatusdrpdwn(), "For Approval");
		ippt.getViewbtn().click();
		slib.progresswait();
		// Assertion client ref should appear in table with approval status
		boolean flag = driver.findElement(By.xpath("//td[contains(text(),'" + clientRefNo + "')]")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println(clientRefNo + " Reference no. is found in approval table");

	}

}
