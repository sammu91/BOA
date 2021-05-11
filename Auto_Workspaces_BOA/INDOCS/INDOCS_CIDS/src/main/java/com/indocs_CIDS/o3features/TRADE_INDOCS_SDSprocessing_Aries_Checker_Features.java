package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_SDS_Checker_AriesCancel_Page;

public class TRADE_INDOCS_SDSprocessing_Aries_Checker_Features {

	WebDriver driver;
	INDOCS_CommonPage cpi;
	seleniumlib slib;
	INDOCS_Common_Features cpif;
	INDOCS_Homepage hpi;
	INDOCS_SDS_Checker_AriesCancel_Page scp;

	public TRADE_INDOCS_SDSprocessing_Aries_Checker_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cpi = new INDOCS_CommonPage(driver);
		slib = new seleniumlib(driver);
		cpif=new INDOCS_Common_Features(driver) ;
		 scp=new INDOCS_SDS_Checker_AriesCancel_Page(driver);
		 hpi= new INDOCS_Homepage(driver);
	}

	public void sds_Checker() {

		String indrefno =TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		slib.clickablewait(hpi.getTradeModule());
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getSDSchkrMenu().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/preceding-sibling::td[3]";

		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		
		scp.getApproveBtn().click();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}

	public void aries_Cancel_Checker() {

		String indrefno =TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);
		
		slib.iWait(1);
		
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();

		cpi.getAriesCancelChkrMenu().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/preceding-sibling::td[3]/input";

		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		
		scp.getAriesCancelBtn().click();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}
}



