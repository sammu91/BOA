package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;
import com.indocs_CIDS.o2pageobjects.CIDS_Export_CheckerPage;


public class EXPORT_CIDS_Checker_Features {

	WebDriver driver;
	CIDS_Common_Features cf;
	CIDS_CommonPage cp;
	CIDS_Export_CheckerPage ecp;
	seleniumlib slib;
	public static String INDOCSrefno;

	public EXPORT_CIDS_Checker_Features(WebDriver driver) {

		// this.driver=Driver.getDriver();
		this.driver = driver;
		cf = new CIDS_Common_Features(driver);
		ecp= new CIDS_Export_CheckerPage(driver);
		cp= new CIDS_CommonPage(driver);
		slib = new seleniumlib(driver);
	}
	
	
	public void approveExport(String clientRefNo ) {
		
		
		cf.hoverExport();
		cp.getExportApprovalMenu().click();
	
		INDOCSrefno=driver.findElement(By.xpath("//td[contains(text(),'"+clientRefNo+"')]/preceding-sibling::td[1]")).getText();
		
		driver.findElement(By.xpath("//td[contains(text(),'"+clientRefNo
				+"')]/preceding-sibling::td/input[@type='checkbox']")).click();
		
		ecp.getApprovebtn().click();
		slib.alertwait();
		String actualmsg=driver.switchTo().alert().getText();
		Assert.assertEquals("Approved successfully.", actualmsg);
		slib.alertaccept();
		System.out.println(actualmsg);
		
		System.out.println(INDOCSrefno);
		
	}
	
	
}
