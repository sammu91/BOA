package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_Export_InitiateMkrMgtPage {

	@FindBy(id = "ContentPlaceHolder1_btnAdd")
	WebElement addbtn;

	@FindBy(id = "ContentPlaceHolder1_ddlSrchStatus")
	WebElement statusdrpdwn;
	
	@FindBy(id = "ContentPlaceHolder1_btnView")
	WebElement viewbtn;
	
	

	public CIDS_Export_InitiateMkrMgtPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getStatusdrpdwn() {
		return statusdrpdwn;
	}

	public WebElement getViewbtn() {
		return viewbtn;
	}

}
