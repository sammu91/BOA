package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_OpsReviewMkr_2_Approval_Page {
	
	@FindBy(id="ContentPlaceHolder1_txtOFACParty2")
	private WebElement ofacField2;
	
	@FindBy(id="ContentPlaceHolder1_btnOFACVerify")
	private WebElement verifyOFACbtn;
	
	@FindBy(id="ContentPlaceHolder1_btnSend")
	private WebElement sendAppbtn;

	
	public INDOCS_OpsReviewMkr_2_Approval_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getOfacField2() {
		return ofacField2;
	}


	public WebElement getSendAppbtn() {
		return sendAppbtn;
	}


	public WebElement getVerifyOFACbtn() {
		return verifyOFACbtn;
	}
	
	
}
