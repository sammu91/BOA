package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_OpsReviewChkr_Approval_Page {
	
	@FindBy(id="ContentPlaceHolder1_btnApprove")
	private WebElement approvebtn;
	
	@FindBy(id="ContentPlaceHolder1_chbCompliance")
	private WebElement complinceCkBx;

	
	public INDOCS_OpsReviewChkr_Approval_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}




	public WebElement getcomplinceCkBx() {
		return complinceCkBx;
	}


	public WebElement getapprovebtn() {
		return approvebtn;
	}
	
	
}
