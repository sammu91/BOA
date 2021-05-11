package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_PaymentFundingChecker_Page {

	
	@FindBy(id="ContentPlaceHolder1_btnApprove")
	private WebElement approveBtn;
	
	
	public CIDS_PaymentFundingChecker_Page(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}


	public WebElement getapproveBtn() {
		return approveBtn;
	}
	
	
}


