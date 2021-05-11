package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_PaymentCheckerPage;


public class TRADE_CIDS_Paymentchecker_Feature {

	WebDriver driver;
	CIDS_Common_Features cf;
	CIDS_CommonPage cp;
	CIDS_PaymentCheckerPage pcp;
	seleniumlib slib;
	public static String INDOCSrefno;

	public TRADE_CIDS_Paymentchecker_Feature(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cf = new CIDS_Common_Features(driver);
		pcp= new CIDS_PaymentCheckerPage(driver);
		cp= new CIDS_CommonPage(driver);
		slib = new seleniumlib(driver);
	}
	
	
	public void approvePayment(String clientRefNo ) {
		
		
		cf.hoverTrade();
		cp.getPaymentChecker().click();
	
		INDOCSrefno=driver.findElement(By.xpath("//td[contains(text(),'"+clientRefNo+"')]/preceding-sibling::td[1]")).getText();
		
		driver.findElement(By.xpath("//td[contains(text(),'"+clientRefNo
				+"')]/preceding-sibling::td/input[@type='checkbox']")).click();
		
		pcp.getApprovebtn().click();
		slib.alertwait();
		String actualmsg=driver.switchTo().alert().getText();
		Assert.assertEquals("Approved successfully.", actualmsg);
		slib.alertaccept();
		System.out.println(actualmsg);
		
		System.out.println(INDOCSrefno);
		
	}
	
	
}
