package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_LoginPage {

	@FindBy(id="txtUserCode")
	private WebElement UserCodeTxtfield;
	
	@FindBy(id="btnLogin")
	private WebElement loginbtn;
	
	
	public INDOCS_LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserCodeTxtfield() {
		return UserCodeTxtfield;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
}
