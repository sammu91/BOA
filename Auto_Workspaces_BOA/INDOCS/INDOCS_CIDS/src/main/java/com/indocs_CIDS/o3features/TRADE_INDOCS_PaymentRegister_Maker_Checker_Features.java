package com.indocs_CIDS.o3features;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_Payment_Register_and_Checker_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;

public class TRADE_INDOCS_PaymentRegister_Maker_Checker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	INDOCS_Payment_Register_and_Checker_Page prcpi;
	seleniumlib slib;

	public TRADE_INDOCS_PaymentRegister_Maker_Checker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		slib = new seleniumlib(driver);
		prcpi = new INDOCS_Payment_Register_and_Checker_Page(driver);
	}

	public void verify_PayReg_Maker() {

		String indrefno = TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getPaymentRegMenu().click();

		prcpi.getAriesRadioBtn().click();
		prcpi.getViewBtn().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[5]/input";
		System.out.println("indocs path saved in string ");

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		// date picker
		prcpi.getpayDatePicker().click();

		// for (int i = 0; i < 2; i++) {
		// prcpi.getDateBackArow().click();
		// }

		prcpi.getFirstDate().click();

		prcpi.getBankRefField().sendKeys("BK1234");

		slib.scrrolldownto_Div_VerticalScroll(prcpi.getInnerDivPopUp());

		prcpi.getMarkPaidBtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}

	public void verify_PayReg_Checker() {

		String indrefno = TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);

		slib.iWait(1);
		
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getPaymentRegChkrMenu().click();

		prcpi.getViewBtn().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[4]/input";
		System.out.println("indocs path saved in string ");

		try {
			slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
			driver.findElement(By.xpath(indocrefnoxpath)).click();

		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		prcpi.getApproveBtnchk().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}

}
