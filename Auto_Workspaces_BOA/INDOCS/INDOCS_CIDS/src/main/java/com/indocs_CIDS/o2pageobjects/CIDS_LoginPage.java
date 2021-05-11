package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_LoginPage {
	
	
	public CIDS_LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="txtCompanyID")
	private WebElement compId;
	
	@FindBy(id="txtUserID")
	private WebElement userId;
	
	@FindBy(id="txtPassword")
	private WebElement pwd;
	
	@FindBy(id="btnLogin")
	private WebElement loginbtn;
	
	

	public WebElement getCompId() {
		return compId;
	}

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	

}
