package com.ipts.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(id="ddlCustomer")
	WebElement customerDrpDn;
	
	@FindBy(id="ibtnIPApp")
	WebElement IPTS;
	
	public HomePage (WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}



	public WebElement getCustomerDrpDn() {
		return customerDrpDn;
	}


	public WebElement getIPTS() {
		return IPTS;
	}
}
