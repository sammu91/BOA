package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_Homepage {

	// Trade
	@FindBy(xpath = "//table[@class='textadminstable']//input[@class='trade']")
	private WebElement tradeModule;

	// Treasury
	@FindBy(xpath = "//table[@class='textadminstable']//input[@class='trsry']")
	private WebElement treasuryModule;

	// Export
	@FindBy(xpath = "//table[@class='textadminstable']//input[@class='tsry']")
	private WebElement exportModule;

	public INDOCS_Homepage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getTradeModule() {
		return tradeModule;
	}

	public WebElement getTreasuryModule() {
		return treasuryModule;
	}

	public WebElement getExportModule() {
		return exportModule;
	}

}
