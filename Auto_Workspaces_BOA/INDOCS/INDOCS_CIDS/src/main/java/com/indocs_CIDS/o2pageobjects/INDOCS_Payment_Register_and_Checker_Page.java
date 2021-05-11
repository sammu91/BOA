package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INDOCS_Payment_Register_and_Checker_Page {

	@FindBy(id = "ContentPlaceHolder1_rblStatus_2")
	private WebElement ariesRadioBtn;

	@FindBy(id = "ContentPlaceHolder1_btnView")
	private WebElement viewBtn;

	@FindBy(id = "ContentPlaceHolder1_imgPaymentDate")
	private WebElement payDatePicker;
	
	@FindBy(id="ContentPlaceHolder1_cePaymentDate_container")
	private WebElement dateBackArow;
	
	@FindBy(xpath="//tbody[@id='ContentPlaceHolder1_cePaymentDate_daysBody']/tr[2]/td[1]/div")
	private WebElement firstDate;
	
	@FindBy(id = "ContentPlaceHolder1_txtBankRefNo")
	private WebElement bankRefField;
	
	@FindBy(id = "ContentPlaceHolder1_btnMarkPaid")
	private WebElement markPaidBtn;

	@FindBy(id = "ContentPlaceHolder1_btnApprove")
	private WebElement approveBtnchk;
	
	@FindBy(id = "ContentPlaceHolder1_pnlBatchDetails")
	private WebElement innerDivPopUp;
	
	
	public INDOCS_Payment_Register_and_Checker_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getAriesRadioBtno() {
		return ariesRadioBtn;
	}

	public WebElement getViewBtn() {
		return viewBtn;
	}

	public WebElement getAriesRadioBtn() {
		return ariesRadioBtn;
	}

	public WebElement getMarkPaidBtn() {
		return markPaidBtn;
	}

	public WebElement getpayDatePicker() {
		return payDatePicker;
	}

	public WebElement getBankRefField() {
		return bankRefField;
	}

	public WebElement getApproveBtnchk() {
		return approveBtnchk;
	}

	public WebElement getPayDatePicker() {
		return payDatePicker;
	}

	public WebElement getDateBackArow() {
		return dateBackArow;
	}

	public WebElement getFirstDate() {
		return firstDate;
	}

	public WebElement getInnerDivPopUp() {
		return innerDivPopUp;
	}

	
}
