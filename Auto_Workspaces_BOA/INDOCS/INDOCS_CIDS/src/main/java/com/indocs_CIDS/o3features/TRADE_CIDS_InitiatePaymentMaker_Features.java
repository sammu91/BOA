package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_InitiatePaymentMkrPage;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_InitiateMkrMgmtPage;

public class TRADE_CIDS_InitiatePaymentMaker_Features {

	WebDriver driver;
	CIDS_CommonPage cp;
	CIDS_InitiateMkrMgmtPage ipp;
	CIDS_InitiatePaymentMkrPage app;
	seleniumlib slib;
	CIDS_Common_Features cf;

	public TRADE_CIDS_InitiatePaymentMaker_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		ipp = new CIDS_InitiateMkrMgmtPage(driver);
		app = new CIDS_InitiatePaymentMkrPage(driver);
		slib = new seleniumlib(driver);
		cf = new CIDS_Common_Features(driver);

	}

	public void addpayment(String branch, String creditCurrency, String clientRefNo, String vendorCode, String amount,
			String invoiceCount) 
	{
		cf.hoverTrade();
		cp.getInitiatePayment().click();

		ipp.getAddbtn().click();

		slib.clickablewait(app.getSelBranch());
		slib.selectdropdown(app.getSelBranch(), branch);
		// slib.selectdropdown(app.getSelBranch(), "3978");

		slib.progresswait();

		slib.selectdropdown(app.getSelCurrency(), creditCurrency);
		// slib.selectdropdown(app.getSelCurrency(), "USD");

		app.getClientref().sendKeys(clientRefNo);
		slib.selectdropdown(app.getSelVendorCode(), vendorCode);
		slib.progresswait();

		app.getCreditAmtfield().sendKeys(amount);

		app.getInvoiceCountfield().sendKeys(invoiceCount);
		app.getSavebtn().click();
		
		slib.progresswait();
	// confirm logic if payment already there	
		
		
		if(slib.isElementPresent(app.getConfirmBtn())) {
			
			app.getConfirmBtn().click();
			slib.progresswait();
		}
		
		
		app.getBrowsedoc().sendKeys(ConfigLib.dirPath+"\\testdata\\Holiday List -2019 Delhi NCR.pdf");
		app.getUploaddoc().click();
		
		slib.alertwait();
		slib.alertaccept();
		app.getInvoiceCkbx().click();
		app.getBOECkbx().click();
		app.getSendbtn().click();
		
		slib.alertwait();
		slib.alertaccept();

		slib.selectdropdown(ipp.getStatusdrpdwn(), "For Approval");
		ipp.getViewbtn().click();
		slib.progresswait();
		// Assertion client ref should appear in table with approval status
		boolean flag = driver.findElement(By.xpath("//td[contains(text(),'" + clientRefNo + "')]")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println(clientRefNo + " Reference no. is found in approval table");
		
		

	}

}
