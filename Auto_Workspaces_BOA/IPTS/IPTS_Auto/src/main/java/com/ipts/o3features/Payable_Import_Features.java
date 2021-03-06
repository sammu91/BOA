package com.ipts.o3features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.ipts.o1generic.ConfigLib;
import com.ipts.o1generic.seleniumlib;
import com.ipts.o2pageobjects.CommonPage;
import com.ipts.o2pageobjects.HomePage;
import com.ipts.o2pageobjects.PayableImportPage;

public class Payable_Import_Features {
	WebDriver driver;
	HomePage hp;
	seleniumlib slib;
	CommonPage cp;
	PayableImportPage pip;

	public Payable_Import_Features(WebDriver driver) {

		this.driver = driver;
		hp = new HomePage(driver);
		slib = new seleniumlib(driver);
		cp = new CommonPage(driver);
		pip = new PayableImportPage(driver);

	}

	public void PayableImport() {

		slib.clickablewait(cp.getImportExportMenu());
		cp.getImportExportMenu().click();
		 slib.clickablewait(cp.getPayImportMenu());
		cp.getPayImportMenu().click();
		pip.getFileUpload().sendKeys(ConfigLib.dirPath + "\\testdata\\Client_File_Upload.xlsx");
		pip.getMDFradibtn().click();
		pip.getUploadBtn().click();

		slib.alertwait();
		String ActualResult = driver.switchTo().alert().getText();
		slib.alertaccept();
		Assert.assertEquals(ActualResult, "{*} Client file uploded successfully.");
		System.out.println(ActualResult);

	}

}
