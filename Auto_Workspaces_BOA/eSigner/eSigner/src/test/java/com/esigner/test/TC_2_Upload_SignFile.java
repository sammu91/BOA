package com.esigner.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eSigner.o1generic.ConfigLib;
import com.eSigner.o1generic.DataProviders;

public class TC_2_Upload_SignFile extends BaseClass {
	
	
	@Test(priority = 1)
	public void verifyLogin() {

		driver.findElement(By.name("username")).sendKeys(ConfigLib.getValue("un"));
		driver.findElement(By.name("password")).sendKeys(ConfigLib.getValue("pwd"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 2, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_InvalidFile_Upload(String catName, String CatUpload, String validFileName,
			String invalidFileName) {

		driver.findElement(By.xpath("//span[contains(text(),'Unsigned Files')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Upload File')]")).click();
		slib.selectdropdown(driver.findElement(By.id("DocType")), CatUpload);
		driver.findElement(By.name("file_Uploader"))
				.sendKeys(ConfigLib.dirPath + "\\testData\\" + invalidFileName + "");
		driver.findElement(By.id("bttn_Upload")).click();

		String ExpectedResult = "1file(s) rejected due to file size. File name(s) :" + invalidFileName + "";
		String actualResult = driver.findElement(By.xpath("//div[contains(text(),'rejected due to file size')]"))
				.getText();

		sa.assertEquals(actualResult, ExpectedResult);

	}

	@Test(priority = 3, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Upload_Doc(String catName, String CatUpload, String validFileName, String invalidFileName) {

		// driver.findElement(By.xpath("//span[contains(text(),'Unsigned
		// Files')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Upload File')]")).click();
		slib.selectdropdown(driver.findElement(By.id("DocType")), CatUpload);
		driver.findElement(By.name("file_Uploader")).sendKeys(ConfigLib.dirPath + "\\testData\\" + validFileName + "");
		driver.findElement(By.id("bttn_Upload")).click();

		WebElement popupxpath = driver.findElement(By.xpath("//div[contains(text(),'file(s) uploaded')]"));
		wait.until(ExpectedConditions.elementToBeClickable(popupxpath));

		String actualresult = popupxpath.getText();
		String expectedResult = "1 file(s) uploaded.";
		Assert.assertEquals(actualresult, expectedResult);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("File uploded verified successfully");

		// Assert data in unsigned table
		String ActualFileNameFound = driver
				.findElement(By.xpath("//td[contains(text(),'" + CatUpload + "')]/preceding-sibling::td[1]/a"))
				.getText();
		System.out.println(ActualFileNameFound + ":::" + validFileName);
		Assert.assertEquals(ActualFileNameFound, validFileName);

	}

	@Test(priority = 4, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Sign_Doc(String catName, String CatUpload, String validFileName, String invalidFileName) {

		driver.findElement(By.xpath("//td[contains(text(),'" + CatUpload + "')]/preceding-sibling::td[2]/input"))
				.click();
		driver.findElement(By.id("btnSign")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Signed Files')]")).click();

		// Assert data in signed table
		String ActualFileNameFound = driver
				.findElement(By.xpath("//td[contains(text(),'" + CatUpload + "')]/preceding-sibling::td[1]")).getText();
		System.out.println(ActualFileNameFound + ":::" + validFileName);
		Assert.assertEquals(ActualFileNameFound, validFileName);

	}

	@Test(priority = 5, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Downalod(String catName, String CatUpload, String validFileName, String invalidFileName) {

		WebElement downloadLink = driver
				.findElement(By.xpath("//td[contains(text(),'" + CatUpload + "')]/following-sibling::td[3]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(downloadLink));
		downloadLink.click();
	}
}
