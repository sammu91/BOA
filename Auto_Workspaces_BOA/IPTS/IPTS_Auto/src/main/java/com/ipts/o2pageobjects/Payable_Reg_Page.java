package com.ipts.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payable_Reg_Page {

// Data entry page
	@FindBy(id = "ContentPlaceHolder1_txtreferenceno")
	private WebElement refNoTxtField;

	@FindBy(id = "ContentPlaceHolder1_btnview")
	private WebElement viewBtn;

	@FindBy(id = "ContentPlaceHolder1_grdPayable_chkTxn_0")
	private WebElement chkBxfirst;

	@FindBy(id = "ContentPlaceHolder1_imgEdit")
	private WebElement editBtn;

	
// edit data entry page
	@FindBy(id = "btnOk")
	private WebElement popupOkBtn;

	@FindBy(id = "btnSend")
	private WebElement sendBtn;

	
// Data verification page
	@FindBy(id = "ContentPlaceHolder1_btnReview")
	private WebElement reviewbtn;

	@FindBy(id = "ContentPlaceHolder1_btnView")
	private WebElement verifyViewBtn;

	
// Review data page
	@FindBy(id = "txtCheckerInvoiceNo")
	private WebElement invoceField;

	@FindBy(id = "ddlCheckerInvoicecurrency")
	private WebElement selCurency;

	@FindBy(id = "txtCheckerInvoiceamt")
	private WebElement amountFld;

	@FindBy(id = "txCheckerboeno")
	private WebElement boeNoFld;

	@FindBy(id = "btnApprove")
	private WebElement aprvBtn;

	@FindBy(id = "ContentPlaceHolder1_txtInvoiceNumber")
	private WebElement filterInvNoField;

	@FindBy(id = "ContentPlaceHolder1_rblStatus_1")
	private WebElement gpfRadiBtn;

	@FindBy(id = "ContentPlaceHolder1_btnOfacVerify")
	private WebElement ofacVerifyBtn;

// Generate Payment batch
	@FindBy(id = "ContentPlaceHolder1_ddlVendor")
	private WebElement vendorDrpDn;

	@FindBy(id = "ContentPlaceHolder1_btnGenerate")
	private WebElement genPaybatBtn;

// OFAC pay bat export

	@FindBy(id = "ContentPlaceHolder1_btngetbatchref")
	private WebElement BatchRefNobtn;

	@FindBy(id = "ContentPlaceHolder1_ddlbatchref")
	private WebElement selBatchRefNoDrpDn;

	@FindBy(id = "ContentPlaceHolder1_txtDateFrom")
	private WebElement dateFrom;

	@FindBy(id = "ContentPlaceHolder1_txtDateTo")
	private WebElement dateTo;

	@FindBy(id = "ContentPlaceHolder1_txtBnkRefNo")
	private WebElement bankRefNoField;

	@FindBy(id = "ContentPlaceHolder1_txtAvaliment")
	private WebElement avalimentField;

	@FindBy(id = "ContentPlaceHolder1_ddlBranch") 
	private WebElement selOFACbranch;

	@FindBy(id = "ContentPlaceHolder1_btnExport")
	private WebElement ofacExportBtn;
	
	
	
// Pay batch register
	@FindBy(id = "ContentPlaceHolder1_ddlCurrency")
	private WebElement selPayBatCurency;
	
	@FindBy(id = "ContentPlaceHolder1_txtBatchDate")
	private WebElement batchDate;
	
	@FindBy(id = "ContentPlaceHolder1_btnView")
	private WebElement payBatViewBtn;
	
	@FindBy(id = "ContentPlaceHolder1_txtRefNo")
	private WebElement payBatBankRefNo;
	

	
// Pay batch register Edit page
	@FindBy(id = "ContentPlaceHolder1_txtAvailmentNo")
	private WebElement paybatAvailmentNo;
	
	@FindBy(id = "ContentPlaceHolder1_txtFXRate")
	private WebElement fxratefld;
	
	@FindBy(id = "ContentPlaceHolder1_txtAccount")
	private WebElement acccountFld;
	
	@FindBy(id = "ContentPlaceHolder1_txtPaymentDesc")
	private WebElement payDescFld;
	
	@FindBy(id = "ContentPlaceHolder1_txtPaymentParty")
	private WebElement thirdPartyFld;
	
	@FindBy(id = "ContentPlaceHolder1_lbtnClose")
	private WebElement markPaidBtn;
	
// Pay batch checker
	@FindBy(id = "ContentPlaceHolder1_btnApprove")
	private WebElement approveBtn;
	
	
// Custome Query > query report page
	
	@FindBy(id = "ContentPlaceHolder1_txtReferenceNo")
	private WebElement qrRefNo;
	
	@FindBy(id = "ContentPlaceHolder1_txtInvoiceNo")
	private WebElement qrInvFld;
	
	@FindBy(id = "ContentPlaceHolder1_cblStatus_0")
	private WebElement activeChkBx;
	
	@FindBy(id = "ContentPlaceHolder1_cblStatus_1")
	private WebElement sentForApprovalChkBx;
	
	@FindBy(id = "ContentPlaceHolder1_cblStatus_2")
	private WebElement gdFrPymntChkBx;
	
	@FindBy(id = "ContentPlaceHolder1_cblStatus_3")
	private WebElement exceptionnChkBx;
	
	@FindBy(id = "ContentPlaceHolder1_cblStatus_4")
	private WebElement payBatChkBx;
	
	
	public Payable_Reg_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}


	
	

	public WebElement getSelPayBatCurency() {
		return selPayBatCurency;
	}

	public WebElement getBatchDate() {
		return batchDate;
	}

	public WebElement getPayBatViewBtn() {
		return payBatViewBtn;
	}

	public WebElement getSelBatchRefNoDrpDn() {
		return selBatchRefNoDrpDn;
	}

	public WebElement getRefNoTxtField() {
		return refNoTxtField;
	}

	public WebElement getViewBtn() {
		return viewBtn;
	}

	public WebElement getChkBxfirst() {
		return chkBxfirst;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getPopupOkBtn() {
		return popupOkBtn;
	}

	public WebElement getSendBtn() {
		return sendBtn;
	}

	public WebElement getReviewbtn() {
		return reviewbtn;
	}

	public WebElement getVerifyViewBtn() {
		return verifyViewBtn;
	}

	public WebElement getInvoceField() {
		return invoceField;
	}

	public WebElement getSelCurency() {
		return selCurency;
	}

	public WebElement getAmountFld() {
		return amountFld;
	}

	public WebElement getBoeNoFld() {
		return boeNoFld;
	}

	public WebElement getAprvBtn() {
		return aprvBtn;
	}

	public WebElement getFilterInvNoField() {
		return filterInvNoField;
	}

	public WebElement getGpfRadiBtn() {
		return gpfRadiBtn;
	}

	public WebElement getOfacVerifyBtn() {
		return ofacVerifyBtn;
	}

	public WebElement getVendorDrpDn() {
		return vendorDrpDn;
	}

	public WebElement getGenPaybatBtn() {
		return genPaybatBtn;
	}

	public WebElement getBatchRefNobtn() {
		return BatchRefNobtn;
	}

	public WebElement getDateFrom() {
		return dateFrom;
	}

	public WebElement getDateTo() {
		return dateTo;
	}

	public WebElement getBankRefNoField() {
		return bankRefNoField;
	}

	public WebElement getAvalimentField() {
		return avalimentField;
	}

	public WebElement getSelOFACbranch() {
		return selOFACbranch;
	}

	public WebElement getOfacExportBtn() {
		return ofacExportBtn;
	}

	public WebElement getPaybatAvailmentNo() {
		return paybatAvailmentNo;
	}

	public WebElement getFxratefld() {
		return fxratefld;
	}

	public WebElement getAcccountFld() {
		return acccountFld;
	}

	public WebElement getPayDescFld() {
		return payDescFld;
	}

	public WebElement getThirdPartyFld() {
		return thirdPartyFld;
	}

	public WebElement getMarkPaidBtn() {
		return markPaidBtn;
	}

	public WebElement getApproveBtn() {
		return approveBtn;
	}

	public WebElement getQrRefNo() {
		return qrRefNo;
	}

	public WebElement getQrInvFld() {
		return qrInvFld;
	}

	public WebElement getActiveChkBx() {
		return activeChkBx;
	}

	public WebElement getSentForApprovalChkBx() {
		return sentForApprovalChkBx;
	}

	public WebElement getGdFrPymntChkBx() {
		return gdFrPymntChkBx;
	}

	public WebElement getExceptionnChkBx() {
		return exceptionnChkBx;
	}

	public WebElement getPayBatChkBx() {
		return payBatChkBx;
	}

	public WebElement getPayBatBankRefNo() {
		return payBatBankRefNo;
	}
	
}
