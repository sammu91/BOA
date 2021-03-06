package com.ipts.o3features;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.ipts.o1generic.ConfigLib;
import com.ipts.o1generic.JDBC_Util;
import com.ipts.o1generic.seleniumlib;
import com.ipts.o2pageobjects.CommonPage;
import com.ipts.o2pageobjects.HomePage;
import com.ipts.o2pageobjects.Payable_Reg_Page;

public class IPTS_Cycle_Features {
	WebDriver driver;
	HomePage hp;
	seleniumlib slib;
	CommonPage cp;
	Payable_Reg_Page prp;

	public IPTS_Cycle_Features(WebDriver driver) {

		this.driver = driver;
		hp = new HomePage(driver);
		slib = new seleniumlib(driver);
		cp = new CommonPage(driver);
		prp = new Payable_Reg_Page(driver);

	}

	/**
	 * 2. This is data entry module method , this method will edit uploaded data and
	 * send for approval.
	 * 
	 * @param refNo
	 */
	public void verfiy_Data_Entry(String refNo) {

		cp.getProcessMenu().click();
		slib.clickablewait(cp.getDataEntryMenu());
		cp.getDataEntryMenu().click();
		prp.getRefNoTxtField().sendKeys(refNo);
		prp.getViewBtn().click();
		prp.getChkBxfirst().click();
		prp.getEditBtn().click();

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window beofer child window appears: "+parentWindow );
		
		
		slib.windowWait(driver, 2);
		Set<String> window = driver.getWindowHandles();
		System.out.println("windows" + window + "size " + window.size());
		Iterator<String> itr = window.iterator();
		String Window1 = itr.next();
		String Window2 = itr.next();
		
		if(parentWindow.equals(Window1)) {
			driver.switchTo().window(Window2);
			System.out.println("Switch to window2");
		}else {
			driver.switchTo().window(Window1);
			System.out.println("Switch to window1");
		}

		driver.manage().window().maximize();
		prp.getPopupOkBtn().click();
		slib.scrrolldown();
		slib.clickablewait(prp.getSendBtn());
		prp.getSendBtn().click();
		slib.alertwait();
		// Assertion
		String Expected_Result = "Record sent for approvals";
		String Actual_Result = slib.getAlertText();
		System.out.println(Actual_Result);
		slib.alertaccept();
		Assert.assertEquals(Actual_Result, Expected_Result, "Data_Entry method Assertion fails");
		driver.switchTo().window(parentWindow);

	}

	/**
	 * 3. This is data verification module method , this method will approve data.
	 * 
	 * @param refNo
	 * @param invNo
	 * @param amount
	 * @param BOEno
	 * @param currency
	 */

	public void verfiy_Data_Verification(String refNo, String invNo, String amount, String BOEno, String currency)
	{
	
		cp.getProcessMenu().click();
		slib.clickablewait(cp.getDataVerfMenu());
		cp.getDataVerfMenu().click();
		prp.getFilterInvNoField().sendKeys(invNo);

		prp.getVerifyViewBtn().click();

		driver.findElement(By.xpath("//td[contains(text(),'" + refNo + "')]/preceding-sibling::td[1]//input")).click();
		
		prp.getReviewbtn().click();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window beofer child window appears: "+parentWindow );

		slib.windowWait(driver, 2);
		Set<String> window = driver.getWindowHandles();
		System.out.println("windows" + window + "size " + window.size());
		Iterator<String> itr = window.iterator();
		String Window1 = itr.next();
		String Window2 = itr.next();

		
		System.out.println("window1 : "+Window1+" Window2: "+ Window2);
		
		if(!parentWindow.equals(Window2)) {
			driver.switchTo().window(Window2);
			System.out.println("Switch to window2");
		}else {
			driver.switchTo().window(Window1);
			System.out.println("Switch to window1");
		}
		
		prp.getInvoceField().sendKeys(invNo);
		slib.selectdropdown(prp.getSelCurency(), currency);
		prp.getAmountFld().sendKeys(amount);
		prp.getBoeNoFld().sendKeys(BOEno);
		prp.getAprvBtn().click();

		slib.alertwait();
		// Assertion
		String Expected_Result = "Process completed successfully.";
		String Actual_Result = slib.getAlertText();
		System.out.println(Actual_Result);
		Assert.assertEquals(Actual_Result, Expected_Result, "Data_Verification method Assertion fails");
		slib.alertaccept();

		// OFAC Verify

		driver.switchTo().window(parentWindow);

		prp.getFilterInvNoField().clear();
		prp.getFilterInvNoField().sendKeys(invNo);
		slib.clickablewait(prp.getGpfRadiBtn());
		prp.getGpfRadiBtn().click();
		prp.getVerifyViewBtn().click();
		
		slib.visiblewait(prp.getOfacVerifyBtn());
		driver.findElement(By.xpath("//td[contains(text(),'" + invNo + "')]/preceding-sibling::td[6]//input")).click();
		
		prp.getOfacVerifyBtn().click();
		slib.alertwait();
		// Assertion
		String Ofac_Expected_Result = "OFAC Verified Successfully for selected payments.";
		String Ofac_Actual_Result = slib.getAlertText();
		System.out.println(Ofac_Actual_Result);
		Assert.assertEquals(Ofac_Actual_Result, Ofac_Expected_Result, "OFAC_Verification Assertion fails");
		slib.alertaccept();

	}

	/**
	 * 4. This method will generate payment batch.
	 * 
	 * @param refNo
	 * @param vendorName
	 */

	public void verfiy_GeneratePaymentBatch(String refNo, String vendorName) {

		cp.getProcessMenu().click();
		slib.clickablewait(cp.getGenPayBatchMenu());
		cp.getGenPayBatchMenu().click();
		slib.selectdropdown(prp.getVendorDrpDn(), vendorName);
		prp.getVerifyViewBtn().click();
		driver.findElement(By.xpath("//td[contains(text(),'" + refNo + "')]/preceding-sibling::td/input")).click();
		prp.getGenPaybatBtn().click();
		slib.alertwait();
		// Assertion
		String Expected_Result = "Payment batch has been generated successfully.";
		String Actual_Result = slib.getAlertText();
		System.out.println(Actual_Result);
		Assert.assertEquals(Actual_Result, Expected_Result, "Generate_PaymentBatch method Assertion fails");
		slib.alertaccept();

	}

	/**
	 * 5. This method will export OFAC Payment Batch for time being this method is commented and assertion need in this
	 * 
	 * @param invNo
	 * @param date
	 */
/*
	public void verfiy_OFACPayBatExport(String invNo, String date) {

		String paymentBatcrefNo = null;
		cp.getImportExportMenu().click();
		cp.getOFACPayBatExportMenu().click();

		ResultSet rs = JDBC_Util.resultQuery("select batchreferenceno  from tx_paymentbatch where paymentbatchid IN "
				+ "( select paymentbatchid from tx_transaction where invoicenumber = '" + invNo + "')");

		try {
			while (rs.next()) {

				paymentBatcrefNo = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBC_Util.closeConnection();

		slib.removeAttribute(prp.getDateFrom(), "onfocus");

		prp.getDateFrom().clear();
		prp.getDateFrom().sendKeys(date);
		prp.getBatchRefNobtn().click();

		try {
			slib.visiblewait(prp.getSelBatchRefNoDrpDn());
			slib.selectdropdown(prp.getSelBatchRefNoDrpDn(), paymentBatcrefNo);
		} catch (Exception e) {
			slib.visiblewait(prp.getSelBatchRefNoDrpDn());
			slib.selectdropdown(prp.getSelBatchRefNoDrpDn(), paymentBatcrefNo);
			System.out.println("Catch worked");
		}finally {
			JDBC_Util.closeConnection();
			
		}

		System.out.println("paymentBatcrefNo is ::" + paymentBatcrefNo);
		prp.getBankRefNoField().sendKeys(ConfigLib.getValue("bankRefNo"));

		String avilmentNo = slib.genRandomDigit(3, 1000);
		prp.getAvalimentField().sendKeys(avilmentNo);
		slib.selectdropdown(prp.getSelOFACbranch(), "6216-New Delhi");
		prp.getOfacExportBtn().click();

	}
	
	
	*/
	
	public void Update_OFAC_Expotr_Query(String refNo) {

		String paymentbatchid = null;
		ResultSet rs = JDBC_Util
				.resultQuery("select paymentbatchid from tx_transaction where referenceno = '" + refNo + "'");
		try {
			while (rs.next()) {

				paymentbatchid = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Util.closeConnection();
		}

		String cutomercode = ConfigLib.getValue("CutomerCode");
		JDBC_Util.updateQuery("update tx_paymentbatch set ofacexportid = '4456' where customercode = '" + cutomercode
				+ "' AND paymentbatchid = '" + paymentbatchid + "'");

		System.out.println("OFAC export query updated Succesfully");
	}

	
	
	
	
	
	
	

	/**
	 * 6. This method will register payment batch and mark it as paid
	 * 
	 * @param vendorName
	 * @param currency
	 * @param date
	 * @param invNo
	 */
	public void verfiy_PaymentBatchReg(String vendorName, String currency, String date, String invNo) {

		String paymentBatcrefNo = null;

		cp.getProcessMenu().click();
		slib.clickablewait(cp.getPayBatRegMenu());
		cp.getPayBatRegMenu().click();
		slib.selectdropdown(prp.getVendorDrpDn(), vendorName);
		slib.selectdropdown(prp.getSelPayBatCurency(), currency);
		slib.removeAttribute(prp.getBatchDate(), "disabled");
		prp.getBatchDate().sendKeys(date);
		prp.getPayBatViewBtn().click();

		ResultSet rs = JDBC_Util.resultQuery("select batchreferenceno  from tx_paymentbatch where paymentbatchid IN "
				+ "( select paymentbatchid from tx_transaction where invoicenumber = '" + invNo + "')");

		try {
			while (rs.next()) {

				paymentBatcrefNo = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC_Util.closeConnection();
			
		}

		System.out.println("paymentBatcrefNo  " + paymentBatcrefNo);
		

		driver.findElement(By.xpath("//td[contains(text(),'" + paymentBatcrefNo + "')]/following-sibling::td[4]/input"))
				.click();
		slib.selectdropdown(prp.getSelOFACbranch(), "6216-New Delhi");
		prp.getPayBatBankRefNo().sendKeys(ConfigLib.getValue("bankRefNo"));
		String avilmentNo = slib.genRandomDigit(3, 1000);
		prp.getPaybatAvailmentNo().sendKeys(avilmentNo);
		prp.getFxratefld().sendKeys("3124");
		prp.getAcccountFld().sendKeys("257600150");
		prp.getPayDescFld().sendKeys("This is testing description");
		prp.getThirdPartyFld().sendKeys("N");
		prp.getMarkPaidBtn().click();
		slib.alertwait();
		// Assertion
		String Expected_Result = "Payment Batch updation sent for approval";
		String Actual_Result = slib.getAlertText();
		Assert.assertEquals(Actual_Result, Expected_Result, "PayBatc register Method Assertion fails");
		System.out.println(slib.getAlertText());
		slib.alertaccept();

	}

	/**
	 * 7. This method will approve payment batch register
	 * 
	 * @param vendorName
	 * @param currency
	 * @param date
	 * @param invNo
	 */
	public void verfiy_PaymentBatchChecker(String vendorName, String currency, String date, String invNo) {

		String paymentBatcrefNo = null;

		cp.getProcessMenu().click();
		slib.clickablewait(cp.getPayBatChkrMenu());
		cp.getPayBatChkrMenu().click();
		slib.selectdropdown(prp.getVendorDrpDn(), vendorName);
		slib.selectdropdown(prp.getSelPayBatCurency(), currency);
		slib.removeAttribute(prp.getBatchDate(), "disabled");
		prp.getBatchDate().sendKeys(date);
		prp.getPayBatViewBtn().click();

		ResultSet rs = JDBC_Util.resultQuery("select batchreferenceno  from tx_paymentbatch where paymentbatchid IN "
				+ "( select paymentbatchid from tx_transaction where invoicenumber = '" + invNo + "')");

		try {
			while (rs.next()) {

				paymentBatcrefNo = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			finally {
			
			JDBC_Util.closeConnection();
		}

		System.out.println("paymentBatcrefNo  " + paymentBatcrefNo);

		driver.findElement(By.xpath("//td[contains(text(),'" + paymentBatcrefNo + "')]/preceding-sibling::td[6]/input"))
				.click();
		prp.getApproveBtn().click();
		slib.alertwait();
		// Assertion
		String Expected_Result = "Approved successfully.";
		String Actual_Result = slib.getAlertText();
		Assert.assertEquals(Actual_Result, Expected_Result, "PayBatc checker Method Assertion fails");
		System.out.println(slib.getAlertText());
		slib.alertaccept();

	}

	/**
	 * 8.This method verify the query report.
	 * 
	 * @param vendorName
	 * @param currency
	 * @param refNo
	 * @param invNo
	 */
	public void verfiy_customQueryReport(String vendorName, String currency, String refNo, String invNo) {

		cp.getQueryRprtMenu().click();
		slib.clickablewait(cp.getCustomQueryMenu());
		cp.getCustomQueryMenu().click();
		slib.selectdropdown(prp.getVendorDrpDn(), vendorName);
		slib.selectdropdown(prp.getSelPayBatCurency(), currency);
		prp.getQrRefNo().sendKeys(refNo);
		prp.getQrInvFld().sendKeys(invNo);
		prp.getActiveChkBx().click();
		prp.getSentForApprovalChkBx().click();
		prp.getGdFrPymntChkBx().click();
		prp.getExceptionnChkBx().click();
		prp.getPayBatChkBx().click();
		prp.getVerifyViewBtn().click();

		By AssertionXP = By.xpath("//table[@id='ContentPlaceHolder1_grdQuery']//td[text()='" + invNo + "']");

		boolean flag2 = slib.isElementPresent(AssertionXP);
		Assert.assertTrue(flag2, "Custom query method assertion fail");
		
		System.out.println("Data found in custome query under closed status");
		

	}

	
	
	
	
	
}
