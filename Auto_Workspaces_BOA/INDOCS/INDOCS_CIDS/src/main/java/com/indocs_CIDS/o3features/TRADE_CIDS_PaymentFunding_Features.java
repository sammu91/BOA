package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_PaymentFunding_Page;

public class TRADE_CIDS_PaymentFunding_Features {

	WebDriver driver;
	CIDS_Common_Features cf;
	CIDS_CommonPage cp;
	seleniumlib slib;
	CIDS_PaymentFunding_Page pfp;

	public TRADE_CIDS_PaymentFunding_Features(WebDriver driver) {

		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		cf = new CIDS_Common_Features(driver);
		slib = new seleniumlib(driver);
		pfp = new CIDS_PaymentFunding_Page(driver);

	}

	public void makePaymentFunding(String fundType,String custAccount, String Amount) {

		cf.hoverTrade();
		cp.getPaymentFunding().click();

		String indocrefnoxpath = "//td[contains(text(),'" + TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno
				+ "')]/following-sibling::td[9]/input";
		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		
		//slib.selectdropdown(pfp.getFundTypedrpdn(), "Contract");
		slib.selectdropdown(pfp.getFundTypedrpdn(), fundType);
		slib.progresswait();
		
		//slib.selectdropdown(pfp.getCutomerAccountdrpdn(), "72447059");
		slib.selectdropdown(pfp.getCutomerAccountdrpdn(), custAccount);
		slib.progresswait();
		
		if (fundType.equalsIgnoreCase("Contract")) {
			pfp.getFwdContractTxtfld().sendKeys("test123");
		}else {
			System.out.println("Contract Field not applicable");
		}
		  // Appears only for contract
		//pfp.getAmountTxtfld().sendKeys("552");
		pfp.getAmountTxtfld().sendKeys(Amount);
		pfp.getAddBtn().click();
		slib.progresswait();
		pfp.getSaveBtn().click();
		slib.alertwait();
		System.out.println(slib.getAlertText());
		slib.alertaccept();

	}

}
