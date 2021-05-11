package com.indocs_CIDS.o2pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIDS_PaymentFunding_Page {

	@FindBy(id = "ContentPlaceHolder1_grdUtilization_ddlFundType")
	private WebElement fundTypedrpdn;

	@FindBy(id = "ContentPlaceHolder1_grdUtilization_ddlCustomerAccount")
	private WebElement cutomerAccountdrpdn;

	@FindBy(id = "ContentPlaceHolder1_grdUtilization_txtForwardContract")
	private WebElement fwdContractTxtfld;

	@FindBy(id = "ContentPlaceHolder1_grdUtilization_txtAmount")
	private WebElement amountTxtfld;

	@FindBy(id = "ContentPlaceHolder1_grdUtilization_ibtnAdd")
	private WebElement addBtn;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	private WebElement saveBtn;
	
	
	public CIDS_PaymentFunding_Page(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	

	public WebElement getFundTypedrpdn() {
		return fundTypedrpdn;
	}

	public WebElement getCutomerAccountdrpdn() {
		return cutomerAccountdrpdn;
	}

	public WebElement getFwdContractTxtfld() {
		return fwdContractTxtfld;
	}

	public WebElement getAmountTxtfld() {
		return amountTxtfld;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	

}
