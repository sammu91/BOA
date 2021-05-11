package com.ipts.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

	@FindBy(xpath = "//a[contains(text(),'Import Export')]")
	WebElement importExportMenu;

	@FindBy(xpath = "//a[contains(text(),'Payable Import')]")
	WebElement payImportMenu;

	@FindBy(xpath = "//a[text()='Process']")
	WebElement processMenu;

	@FindBy(xpath = "//a[text()='Data Entry Module']")
	WebElement DataEntryMenu;

	@FindBy(xpath = "//a[text()='Data Verification Module']")
	WebElement DataVerfMenu;

	@FindBy(xpath = "//a[text()='Generate Payment Batch']")
	WebElement GenPayBatchMenu;

	@FindBy(xpath = "//a[text()='OFAC Pay Batch Export']")
	WebElement OFACPayBatExportMenu;

	@FindBy(xpath = "//a[text()='Payment Batch Register']")
	WebElement payBatRegMenu;

	@FindBy(xpath = "//a[text()='Payment Batch checker']")
	WebElement payBatChkrMenu;

	
// Query Report	
	@FindBy(xpath = "//a[text()='Query Report']")
	WebElement queryRprtMenu;
	
	@FindBy(xpath = "//a[text()='Custom Query']")
	WebElement customQueryMenu;
	
	
	public CommonPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	
	
	public WebElement getPayBatRegMenu() {
		return payBatRegMenu;
	}

	public WebElement getPayBatChkrMenu() {
		return payBatChkrMenu;
	}

	public WebElement getOFACPayBatExportMenu() {
		return OFACPayBatExportMenu;
	}

	public WebElement getGenPayBatchMenu() {
		return GenPayBatchMenu;
	}

	public WebElement getImportExportMenu() {
		return importExportMenu;
	}

	public WebElement getPayImportMenu() {
		return payImportMenu;
	}

	public WebElement getProcessMenu() {
		return processMenu;
	}

	public WebElement getDataEntryMenu() {
		return DataEntryMenu;
	}

	public WebElement getDataVerfMenu() {
		return DataVerfMenu;
	}

	public WebElement getQueryRprtMenu() {
		return queryRprtMenu;
	}

	public WebElement getCustomQueryMenu() {
		return customQueryMenu;
	}

}