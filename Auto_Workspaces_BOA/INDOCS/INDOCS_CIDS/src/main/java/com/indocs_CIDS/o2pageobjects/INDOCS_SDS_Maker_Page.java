package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_SDS_Maker_Page {

	
	@FindBy(id="ContentPlaceHolder1_txtSDSRefNo")
	private WebElement SDSrefNo;
	

	@FindBy(id="ContentPlaceHolder1_btnSave")
	private WebElement saveBtn;
	
	public INDOCS_SDS_Maker_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getSDSrefNo() {
		return SDSrefNo;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}

