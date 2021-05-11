package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_InitiatePaymentMkrPage {

	@FindBy(id = "ContentPlaceHolder1_ddlBranch")
	WebElement selBranch;

	@FindBy(id = "ContentPlaceHolder1_ddlAccount")
	WebElement selAccount;

	@FindBy(id = "ContentPlaceHolder1_ddlBatchCurrency")
	WebElement selCurrency;

	@FindBy(id = "ContentPlaceHolder1_ddlBatchVendor")
	WebElement selVendorCode;

	@FindBy(id = "ContentPlaceHolder1_ddlCharges")
	WebElement selCharges;

	@FindBy(id = "ContentPlaceHolder1_txtPaymentRefNo")
	WebElement clientref;

	@FindBy(id = "ContentPlaceHolder1_rbCr")
	WebElement creditradiobtn;

	@FindBy(id = "ContentPlaceHolder1_txtCreditAmt")
	WebElement creditAmtfield;

	@FindBy(id = "ContentPlaceHolder1_txtInvoiceCount")
	WebElement invoiceCountfield;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	WebElement savebtn;
	
	// confirm button if payment already there
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnConfirm']")
	WebElement confirmBtn;
	
	

	// payment detail page
	@FindBy(id = "ContentPlaceHolder1_fuDocument")
	WebElement browsedoc;

	@FindBy(id = "ContentPlaceHolder1_btnUpload")
	WebElement uploaddoc;
	
	@FindBy(id = "ContentPlaceHolder1_chkDocumentList_0")
	WebElement invoiceCkbx;
	
	@FindBy(id = "ContentPlaceHolder1_chkDocumentList_1")
	WebElement BOECkbx;
	
	@FindBy(id = "ContentPlaceHolder1_btnSendPayBatch")
	WebElement sendbtn;
	

	public CIDS_InitiatePaymentMkrPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public WebElement getSelBranch() {
		return selBranch;
	}

	public WebElement getSelAccount() {
		return selAccount;
	}

	public WebElement getSelCurrency() {
		return selCurrency;
	}

	public WebElement getSelVendorCode() {
		return selVendorCode;
	}

	public WebElement getSelCharges() {
		return selCharges;
	}

	public WebElement getClientref() {
		return clientref;
	}

	public WebElement getCreditradiobtn() {
		return creditradiobtn;
	}

	public WebElement getCreditAmtfield() {
		return creditAmtfield;
	}

	public WebElement getInvoiceCountfield() {
		return invoiceCountfield;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getBrowsedoc() {
		return browsedoc;
	}

	public WebElement getUploaddoc() {
		return uploaddoc;
	}

	public WebElement getInvoiceCkbx() {
		return invoiceCkbx;
	}

	public WebElement getBOECkbx() {
		return BOECkbx;
	}

	public WebElement getSendbtn() {
		return sendbtn;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	
}
