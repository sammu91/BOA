package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_TRSRY_PaymentCheckerPage {

	
	@FindBy(id = "ContentPlaceHolder1_btnApprove")
	WebElement approvebtn;
	
	
	
	public CIDS_TRSRY_PaymentCheckerPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}



	public WebElement getApprovebtn() {
		return approvebtn;
	}
	
	
	
}
