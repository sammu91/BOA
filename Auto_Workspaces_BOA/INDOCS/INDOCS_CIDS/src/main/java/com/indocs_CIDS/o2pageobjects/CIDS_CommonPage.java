package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_CommonPage {

	@FindBy(id = "UpdateProgress")
	WebElement Progress;

	// Trade
	@FindBy(xpath = "//a[text()='TRADE']")
	private WebElement tradeMenu;

	@FindBy(xpath = "//a[contains(@href,'TDNBULK/PayBatchReg.aspx')]")
	private WebElement initiatePayment;

	@FindBy(xpath = "//a[contains(@href,'TDNBULK/PayBatchChecker.aspx')]")
	private WebElement paymentChecker;

	@FindBy(xpath = "//a[contains(@href,'TDNBULK/PayBatchUtil.aspx')]")
	private WebElement paymentFunding;

	@FindBy(xpath = "//a[contains(@href,'TDNBULK/PayBatchUtilChecker.aspx')]")
	private WebElement paymentFundingChecker;
	
	

	
	// TREASURY
	@FindBy(xpath = "//a[text()='TREASURY']")
	private WebElement treasuryMenu;

	@FindBy(xpath = "//a[contains(@href,'TRSRY/PayBatchReg.aspx')]")
	private WebElement initiatePaymentTRSRY;

	@FindBy(xpath = "//a[contains(@href,'TRSRY/PayBatchChecker.aspx')]")
	private WebElement paymentCheckerTRSRY;

	@FindBy(xpath = "//a[contains(@href,'TRSRY/PayBatchUtil.aspx')]")
	private WebElement paymentFundingTRSRY;

	@FindBy(xpath = "//a[contains(@href,'TRSRY/PayBatchUtilChecker.aspx')]")
	private WebElement paymentFundingCheckerTRSRY;
	
	
	// EXPORT
	@FindBy(xpath = "//a[text()='EXPORT']")
	private WebElement exportMenu;

	@FindBy(linkText="Initiation (Maker)")
	private WebElement initiationMkrMenu;
	
	@FindBy(linkText="Approval (Checker)")
	private WebElement exportApprovalMenu;

	
	public CIDS_CommonPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	
	public WebElement getTradeMenu() {
		return tradeMenu;
	}

	public WebElement getProgress() {
		return Progress;
	}

	public WebElement getInitiatePayment() {
		return initiatePayment;
	}

	public WebElement getPaymentChecker() {
		return paymentChecker;
	}

	public WebElement getPaymentFunding() {
		return paymentFunding;
	}

	public WebElement getPaymentFundingChecker() {
		return paymentFundingChecker;
	}

	public WebElement getTreasuryMenu() {
		return treasuryMenu;
	}

	public WebElement getInitiatePaymentTRSRY() {
		return initiatePaymentTRSRY;
	}

	public WebElement getPaymentCheckerTRSRY() {
		return paymentCheckerTRSRY;
	}

	public WebElement getPaymentFundingTRSRY() {
		return paymentFundingTRSRY;
	}

	public WebElement getPaymentFundingCheckerTRSRY() {
		return paymentFundingCheckerTRSRY;
	}


	public WebElement getExportMenu() {
		return exportMenu;
	}


	public WebElement getInitiationExportMenu() {
		return initiationMkrMenu;
	}


	public WebElement getExportApprovalMenu() {
		return exportApprovalMenu;
	}

	
}
