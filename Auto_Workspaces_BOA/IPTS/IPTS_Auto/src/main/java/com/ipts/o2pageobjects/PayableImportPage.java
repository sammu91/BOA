package com.ipts.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayableImportPage {

	@FindBy(id = "ContentPlaceHolder1_fuUpload")
	private WebElement fileUpload;

	@FindBy(id = "ContentPlaceHolder1_rblPayableImport_1")
	private WebElement MDFradibtn;

	@FindBy(id = "ContentPlaceHolder1_btnUpload")
	private WebElement uploadBtn;

	public PayableImportPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}

	public WebElement getMDFradibtn() {
		return MDFradibtn;
	}

	public WebElement getUploadBtn() {
		return uploadBtn;
	}

}
