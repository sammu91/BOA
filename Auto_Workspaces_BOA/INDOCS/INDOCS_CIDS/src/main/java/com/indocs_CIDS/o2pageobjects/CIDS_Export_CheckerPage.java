package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_Export_CheckerPage {

	
	@FindBy(id = "ContentPlaceHolder1_btnApprove")
	WebElement approvebtn;
	
	
	
	public CIDS_Export_CheckerPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}



	public WebElement getApprovebtn() {
		return approvebtn;
	}
	
	
	
}
