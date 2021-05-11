package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_OpsReviewMkr_Approval_Page {
	
	@FindBy(id="ContentPlaceHolder1_txtOfacParty")
	private WebElement ofacField;
	
	
	@FindBy(id="ContentPlaceHolder1_btnSend")
	private WebElement sendAppbtn;

	
	public INDOCS_OpsReviewMkr_Approval_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getOfacField() {
		return ofacField;
	}


	public WebElement getSendAppbtn() {
		return sendAppbtn;
	}
	
	
}
