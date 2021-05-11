package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_OpsReviewChkr_Page {
	
	
	@FindBy(id="ContentPlaceHolder1_btnView")
	private WebElement viewBtn;
	
	@FindBy(xpath=" //a[contains(text(),'Initiation Date')]")
	private WebElement sortdate;
	
	
	
	public INDOCS_OpsReviewChkr_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getViewBtn() {
		return viewBtn;
	}


	public WebElement getSortdate() {
		return sortdate;
	}

	
}
