package com.indocs_CIDS.o3features;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.indocs_CIDS.o1generic.JDBC_Util;
import com.indocs_CIDS.o1generic.seleniumlib;
import com.indocs_CIDS.o2pageobjects.INDOCS_Homepage;
import com.indocs_CIDS.o2pageobjects.INDOCS_CommonPage;
import com.indocs_CIDS.o2pageobjects.INDOCS_EXPORT_OpsReviewMkrMgmt_Page;
import com.indocs_CIDS.o2pageobjects.INDOCS_EXPORT_OpsReviewMkr_Approval_Page;

public class EXPORT_INDOCS_OpsReviewerMaker_Features {

	WebDriver driver;
	INDOCS_Homepage hpi;
	INDOCS_CommonPage cpi;
	INDOCS_Common_Features cpif;
	INDOCS_EXPORT_OpsReviewMkrMgmt_Page eormpi;
	INDOCS_EXPORT_OpsReviewMkr_Approval_Page eormapi;
	seleniumlib slib;

	public EXPORT_INDOCS_OpsReviewerMaker_Features(WebDriver driver) {

		this.driver = driver;
		hpi = new INDOCS_Homepage(driver);
		cpi = new INDOCS_CommonPage(driver);
		cpif = new INDOCS_Common_Features(driver);
		eormpi = new INDOCS_EXPORT_OpsReviewMkrMgmt_Page(driver);
		eormapi = new INDOCS_EXPORT_OpsReviewMkr_Approval_Page(driver);
		slib = new seleniumlib(driver);
	}


	public  void updateDocID() {

		String indrefno = EXPORT_CIDS_Checker_Features.INDOCSrefno;
		String getPaybatIdquery= "select paymentbatchid from tx_tdexp_paymentbatch where batchreferenceno='" + indrefno + "'";
		ResultSet rs = JDBC_Util.resultQuery(getPaybatIdquery);
		
		Random rd= new Random();
		String docID = String.format("%04d", rd.nextInt(10000));
		System.out.println("Doc id is "+docID );

		try {
			while (rs.next()) {

				String paymentbatchid = rs.getString(1);
				JDBC_Util.updateQuery("update tx_tdexp_document set documentid='"+docID+"' where paymentbatchid="+paymentbatchid+"");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("document ID updated");
		JDBC_Util.closeConnection();
		System.out.println("DB connection close");
	}

	
	public void verify_EXPORT_ops_Review_Maker(String branch) {

		String indrefno = EXPORT_CIDS_Checker_Features.INDOCSrefno;
		System.out.println(indrefno);


		slib.iWait(1);
		
		hpi.getExportModule().click();
		cpif.hoverExport();
		cpi.getOpsRevMkrmenuEXPORT().click();

		eormpi.getViewBtn().click();
		slib.visiblewait(eormpi.getSortdate());
		eormpi.getSortdate().click();

		String indocrefnoxpath = "//td[contains(text(),'" + indrefno + "')]/following-sibling::td[8]/input";
		System.out.println("indocs path saved in string ");

		try {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
		} catch (Exception e) {
			driver.findElement(By.xpath(indocrefnoxpath)).click();
			System.out.println("catch worked");
		}

		slib.clickablewait(eormapi.getSelBranch());

		slib.selectdropdown(eormapi.getSelBranch(), branch);
		eormapi.getLCfield().sendKeys("LC1234");

		// slib.scrrolldown();
		eormapi.getSendAppbtn().click();

		slib.alertwait();
		System.out.println(slib.getAlertText());

		slib.alertaccept();

	}
}
