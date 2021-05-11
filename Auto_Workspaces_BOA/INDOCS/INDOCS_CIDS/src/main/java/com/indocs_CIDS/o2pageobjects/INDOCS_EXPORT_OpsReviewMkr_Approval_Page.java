package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_EXPORT_OpsReviewMkr_Approval_Page {
	
	@FindBy(id="ContentPlaceHolder1_ddlBranch")
	private WebElement selBranch;
	
	@FindBy(id="ContentPlaceHolder1_txtBankRefNo")
	private WebElement LCfield;
	
	
	@FindBy(id="ContentPlaceHolder1_btnSendPayBatch")
	private WebElement sendAppbtn;

	
	
	public INDOCS_EXPORT_OpsReviewMkr_Approval_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}




	public WebElement getSendAppbtn() {
		return sendAppbtn;
	}


	public WebElement getSelBranch() {
		return selBranch;
	}


	public WebElement getLCfield() {
		return LCfield;
	}
	
	
}
