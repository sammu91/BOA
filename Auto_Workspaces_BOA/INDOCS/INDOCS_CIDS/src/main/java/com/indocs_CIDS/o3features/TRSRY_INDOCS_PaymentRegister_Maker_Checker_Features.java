package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.TRSRY_INDOCS_Payment_Register_and_Checker_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRSRY_INDOCS_PaymentRegister_Maker_Checker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	TRSRY_INDOCS_Payment_Register_and_Checker_Page tprcpi;
	seleniumlib slib;

	public TRSRY_INDOCS_PaymentRegister_Maker_Checker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		slib = new seleniumlib(driver);
		tprcpi = new TRSRY_INDOCS_Payment_Register_and_Checker_Page(driver);
	}

	public void verify_TRSRY_PayReg_Maker() {

		String indrefno = TRSRY_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);
		
		slib.iWait(1);
		
		hpi.getTreasuryModule().click();
		cpif.hoverTreasuryProcess();;
		cpi.getPaymentRegMenuTRSRY().click();

		tprcpi.getClientAprvRdBtn().click();
		tprcpi.getViewBtn().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[4]/input";
		System.out.println("indocs path saved in string ");

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		// date picker
		tprcpi.getpayDatePicker().click();


		tprcpi.getFirstDate().click();

		tprcpi.getBankRefField().sendKeys("BK1234");

		slib.scrrolldownto_Div_VerticalScroll(tprcpi.getInnerDivPopUp());

		tprcpi.getMarkPaidBtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}
	
	

	public void verify_TRSRY_PayReg_Checker() {

		String indrefno = TRSRY_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);

		slib.iWait(1);
		
		hpi.getTreasuryModule().click();
		cpif.hoverTreasuryProcess();
		cpi.getPaymentRegChkrMenuTRSRY().click();

		tprcpi.getViewBtn().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[4]/input";
		System.out.println("indocs path saved in string ");

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		tprcpi.getApproveBtnchk().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}

}
