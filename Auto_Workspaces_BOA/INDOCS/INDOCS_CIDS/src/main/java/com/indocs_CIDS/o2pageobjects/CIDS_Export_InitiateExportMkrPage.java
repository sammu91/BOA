package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_Export_InitiateExportMkrPage {

	@FindBy(id = "ContentPlaceHolder1_ddlBatchCurrency")
	WebElement selCurrency;

	@FindBy(id = "ContentPlaceHolder1_txtTotalAmt")
	WebElement amtField;

	@FindBy(id = "ContentPlaceHolder1_ddlType")
	WebElement typeDrpdn;

	@FindBy(id = "ContentPlaceHolder1_txtBuyerName")
	WebElement buyerField;

	@FindBy(id = "ContentPlaceHolder1_txtPaymentRefNo")
	WebElement clientRefNum;

	@FindBy(id = "ContentPlaceHolder1_txtShBillNums")
	WebElement SBnum;

	@FindBy(id = "ContentPlaceHolder1_btnAddShbilNums")
	WebElement addSBbtn;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	WebElement savebtn;

	// payment detail page
	@FindBy(id = "ContentPlaceHolder1_fuDocument")
	WebElement browsedoc;

	@FindBy(id = "ContentPlaceHolder1_btnUpload")
	WebElement uploaddoc;

	@FindBy(id = "ContentPlaceHolder1_chkDocumentList_0")
	WebElement ShipingCkbx;

	@FindBy(id = "ContentPlaceHolder1_chkDocumentList_1")
	WebElement invoiceCkbx;

	@FindBy(id = "ContentPlaceHolder1_btnSendPayBatch")
	WebElement sendbtn;

	public CIDS_Export_InitiateExportMkrPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public WebElement selCurrency() {
		return selCurrency;
	}

	public WebElement getAmtField() {
		return amtField;
	}

	public WebElement selTypeDrpdn() {
		return typeDrpdn;
	}

	public WebElement getBuyerField() {
		return buyerField;
	}

	public WebElement getClientRefNum() {
		return clientRefNum;
	}

	public WebElement getSBnum() {
		return SBnum;
	}

	public WebElement getAddSBbtn() {
		return addSBbtn;
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

	public WebElement getShipingCkbx() {
		return ShipingCkbx;
	}

	public WebElement getInvoiceCkbx() {
		return invoiceCkbx;
	}

	public WebElement getSendbtn() {
		return sendbtn;
	}

}
