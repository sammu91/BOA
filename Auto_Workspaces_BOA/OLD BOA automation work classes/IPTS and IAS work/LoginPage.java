package com.ipts.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (id="btnLogin")
	private WebElement lgnbtn;
	
	@FindBy (id="txtUserCode")
	private WebElement userCode;
	
	
	public LoginPage(WebDriver driver){
		
		
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getLgnbtn() {
		return lgnbtn;
	}


	public WebElement getUserCode() {
		return userCode;
	}

	
	
}
