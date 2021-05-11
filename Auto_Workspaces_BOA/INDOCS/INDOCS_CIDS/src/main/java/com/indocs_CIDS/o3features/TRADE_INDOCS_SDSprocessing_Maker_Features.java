package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_SDS_Maker_Page;

public class TRADE_INDOCS_SDSprocessing_Maker_Features {

	WebDriver driver;
	INDOCS_CommonPage cpi;
	seleniumlib slib;
	INDOCS_Common_Features cpif;
	INDOCS_Homepage hpi;
	INDOCS_SDS_Maker_Page spmp;

	public TRADE_INDOCS_SDSprocessing_Maker_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cpi = new INDOCS_CommonPage(driver);
		slib = new seleniumlib(driver);
		cpif=new INDOCS_Common_Features(driver) ;
		spmp = new INDOCS_SDS_Maker_Page(driver);
		hpi= new INDOCS_Homepage(driver);

	}

	public void sds_Maker() {

		String indrefno = TRADE_CIDS_Paymentchecker_Feature.INDOCSrefno;
		System.out.println(indrefno);
		
		System.out.println(hpi.getTradeModule());
		

		slib.iWait(1);
		
		hpi.getTradeModule().click();
		cpif.hoverTradeProcess();
		cpi.getSDSmakerMenu().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[8]/input";

		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();
		
		spmp.getSDSrefNo().sendKeys("sds123456"); //should be eigth digit alphnumeric no special charcter
		
		spmp.getSaveBtn().click();
		
		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}

}



