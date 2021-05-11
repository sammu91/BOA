package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_Export_InitiateExportMkrPage;
import com.indocs_CIDS.o2pageobjects.CIDS_Export_InitiateMkrMgtPage;

public class EXPORT_CIDS_InitiateExportMkr_Features {

	WebDriver driver;
	CIDS_CommonPage cp;
	CIDS_Export_InitiateMkrMgtPage iep;
	CIDS_Export_InitiateExportMkrPage aep;
	seleniumlib slib;
	CIDS_Common_Features cf;

	public EXPORT_CIDS_InitiateExportMkr_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		iep = new CIDS_Export_InitiateMkrMgtPage(driver);
		aep = new CIDS_Export_InitiateExportMkrPage(driver);
		slib = new seleniumlib(driver);
		cf = new CIDS_Common_Features(driver);

	}

	public void ExportMkr(String currency, String amount,String type,String buyer, String clientRefNo,String SBnum) 
	{
		cf.hoverExport();
		cp.getInitiationExportMenu().click();

		iep.getAddbtn().click();

		slib.clickablewait(aep.selCurrency());
		slib.selectdropdown(aep.selCurrency(), currency);
				
		aep.getAmtField().sendKeys(amount);
		slib.selectdropdown(aep.selTypeDrpdn(), type);

		aep.getBuyerField().sendKeys(buyer);
		aep.getClientRefNum().sendKeys(clientRefNo);

		aep.getSBnum().sendKeys(SBnum);
		aep.getAddSBbtn().click();
		slib.progresswait();
		aep.getSavebtn().click();
		
		slib.progresswait();
		aep.getBrowsedoc().sendKeys(ConfigLib.dirPath+"\\testdata\\Holiday List -2019 Delhi NCR.pdf");
		aep.getUploaddoc().click();
		
		slib.alertwait();
		slib.alertaccept();
		aep.getShipingCkbx().click();
		aep.getInvoiceCkbx().click();
		aep.getSendbtn().click();
		slib.alertwait();
		slib.alertaccept();

		slib.selectdropdown(iep.getStatusdrpdwn(), "For Approval");
		iep.getViewbtn().click();
		slib.progresswait();
		// Assertion client ref should appear in table with approval status
		boolean flag = driver.findElement(By.xpath("//span[contains(text(),'" + clientRefNo + "')]")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println(clientRefNo + " Reference no. is found in approval table");
		
		

	}

}
