package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_CommonPage {

// Trade
	@FindBy(xpath = "//a[text()='TRADE PROCESS']")
	private WebElement tradeprocessmenu;

	@FindBy(xpath = "//a[text()='Ops Review Maker']")
	private WebElement opsReviewMkrmenu;

	@FindBy(xpath = "//a[text()='Ops Maker2']")
	private WebElement opsmaker2;

	@FindBy(xpath = "//a[text()='Ops Review Checker ']")
	private WebElement opsReviewChkrMenu;
	
	@FindBy(xpath = "//a[text()='SDS Processing Maker']")
	private WebElement SDSmakerMenu;
	
	@FindBy(xpath = "//a[text()='SDS Processing Checker']")
	private WebElement SDSchkrMenu;
	
	@FindBy(xpath = "//a[text()='Aries Cancellation Checker']")
	private WebElement ariesCancelChkrMenu;
	
	@FindBy(xpath = "//a[text()='Payment Register']")
	private WebElement paymentRegMenu;
	
	@FindBy(xpath = "//a[text()='Payment Register Checker']")
	private WebElement paymentRegChkrMenu;
	
	
	
// Treasury	
	@FindBy(xpath = "//a[text()='TREASURY PROCESS']")
	private WebElement treasuryProcessMenu;

	@FindBy(xpath = "//a[text()='Ops Review Maker']")
	private WebElement opsReviewMkrmenuTRSRY;

	@FindBy(xpath = "//a[contains(text(),'Ops Review Checker')]")
	private WebElement opsReviewChkrMenuTRSRY;
	
	@FindBy(xpath = "//a[text()='Payment Register']")
	private WebElement paymentRegMenuTRSRY;
	
	@FindBy(xpath = "//a[text()='Payment Register Checker']")
	private WebElement paymentRegChkrMenuTRSRY;
	
	
// Export
	@FindBy(xpath = "//a[text()='EXPORT']")
	private WebElement exportMenu;

	@FindBy(xpath = "//a[text()='Ops Review Maker']")
	private WebElement opsRevMkrmenuEXPORT;

	@FindBy(xpath = "//a[contains(text(),'Ops Review Checker')]")
	private WebElement opsRevChkrMenuEXPORT;
	
	
	
	
	public INDOCS_CommonPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getTradeprocessmenu() {
		return tradeprocessmenu;
	}

	public WebElement getOpsReviewMkrmenu() {
		return opsReviewMkrmenu;
	}

	public WebElement getOpsmaker2() {
		return opsmaker2;
	}

	public WebElement getOpsReviewChkrMenu() {
		return opsReviewChkrMenu;
	}

	public WebElement getTreasuryProcessMenu() {
		return treasuryProcessMenu;
	}

	public WebElement getOpsReviewMkrmenuTRSRY() {
		return opsReviewMkrmenuTRSRY;
	}

	public WebElement getOpsReviewChkrMenuTRSRY() {
		return opsReviewChkrMenuTRSRY;
	}

	public WebElement getExportMenu() {
		return exportMenu;
	}

	public WebElement getOpsRevMkrmenuEXPORT() {
		return opsRevMkrmenuEXPORT;
	}

	public WebElement getOpsRevChkrMenuEXPORT() {
		return opsRevChkrMenuEXPORT;
	}

	public WebElement getSDSmakerMenu() {
		return SDSmakerMenu;
	}

	public WebElement getSDSchkrMenu() {
		return SDSchkrMenu;
	}

	public WebElement getAriesCancelChkrMenu() {
		return ariesCancelChkrMenu;
	}

	public WebElement getPaymentRegMenu() {
		return paymentRegMenu;
	}

	public WebElement getPaymentRegChkrMenu() {
		return paymentRegChkrMenu;
	}

	public WebElement getPaymentRegMenuTRSRY() {
		return paymentRegMenuTRSRY;
	}

	public WebElement getPaymentRegChkrMenuTRSRY() {
		return paymentRegChkrMenuTRSRY;
	}

	
}
