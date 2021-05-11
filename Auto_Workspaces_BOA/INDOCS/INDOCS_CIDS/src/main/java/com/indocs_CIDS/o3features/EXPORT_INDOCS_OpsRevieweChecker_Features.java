package com.indocs_CIDS.o3features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;
import com.indocs_CIDS.o2pageobjects.INDOCS_EXPORT_OpsReviewChkr_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_EXPORt_OpsReviewChkr_Approval_Page;

public class EXPORT_INDOCS_OpsRevieweChecker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	seleniumlib slib;
	INDOCS_EXPORT_OpsReviewChkr_Page eorcpi;
	INDOCS_EXPORt_OpsReviewChkr_Approval_Page eorcapi;

	public EXPORT_INDOCS_OpsRevieweChecker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		slib = new seleniumlib(driver);
		eorcpi = new INDOCS_EXPORT_OpsReviewChkr_Page(driver);
		eorcapi = new INDOCS_EXPORt_OpsReviewChkr_Approval_Page(driver);

	}

	public void verify_EXPORT_ops_Review_Checker() {

		String indrefno = EXPORT_CIDS_Checker_Features.INDOCSrefno;
		System.out.println(indrefno);


		slib.iWait(1);
		
		hpi.getExportModule().click();
		cpif.hoverExport();
		cpi.getOpsRevChkrMenuEXPORT().click();

		eorcpi.getViewBtn().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[5]/input";

		slib.clickablewait(driver.findElement(By.xpath(indocrefnoxpath)));
		driver.findElement(By.xpath(indocrefnoxpath)).click();

		slib.clickablewait(eorcapi.getapprovebtn());
		eorcapi.getapprovebtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}
}
