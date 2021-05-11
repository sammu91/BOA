package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_SDS_Checker_AriesCancel_Page {


	@FindBy(id="ContentPlaceHolder1_btnApprove")
	private WebElement approveBtn;
	

	@FindBy(id="ContentPlaceHolder1_btnCancel")
	private WebElement ariesCancelBtn;
	
	public INDOCS_SDS_Checker_AriesCancel_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getApproveBtn() {
		return approveBtn;
	}


	public WebElement getAriesCancelBtn() {
		return ariesCancelBtn;
	}
	
	
	
}

