package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_TRSRY_PaymentFunding_Page;

public class TRSRY_CIDS_PaymentFunding_Features {

	WebDriver driver;
	CIDS_Common_Features cf;
	CIDS_CommonPage cp;
	seleniumlib slib;
	CIDS_TRSRY_PaymentFunding_Page pfpt;

	public TRSRY_CIDS_PaymentFunding_Features(WebDriver driver) {

		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
		cf = new CIDS_Common_Features(driver);
		slib = new seleniumlib(driver);
		pfpt = new CIDS_TRSRY_PaymentFunding_Page(driver);

	}

	public void makePaymentFundingTRSRY(String fundType,String custAccount, String Amount) {

		String indrefno = TRSRY_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);
		cf.hoverTreasury();;
		cp.getPaymentFundingTRSRY().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno+ "')]/following-sibling::td[9]/input";
		
		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		
		//slib.selectdropdown(pfp.getFundTypedrpdn(), "Contract");
		
		slib.clickablewait(pfpt.getFundTypedrpdn());
		slib.selectdropdown(pfpt.getFundTypedrpdn(), fundType);
		slib.progresswait();
		
		//slib.selectdropdown(pfp.getCutomerAccountdrpdn(), "72447059");
		slib.selectdropdown(pfpt.getCutomerAccountdrpdn(), custAccount);
		slib.progresswait();
		
		if (fundType.equalsIgnoreCase("Contract")) {
			pfpt.getFwdContractTxtfld().sendKeys("test123");
		}else {
			System.out.println("Contract Field not applicable");
		}
		  // Appears only for contract
		//pfp.getAmountTxtfld().sendKeys("552");
		pfpt.getAmountTxtfld().sendKeys(Amount);
		pfpt.getAddBtn().click();
		slib.progresswait();
		pfpt.getSaveBtn().click();
		slib.alertwait();
		System.out.println(slib.getAlertText());
		slib.alertaccept();

	}

}
