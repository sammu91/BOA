package com.esigner.test;

import java.util.concurrent.SynchronousQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eSigner.o1generic.ConfigLib;
import com.eSigner.o1generic.DataProviders;

public class TCsuite extends BaseClass {

	@Test(priority = 1)
	public void verifyLogin() {

		driver.findElement(By.name("username")).sendKeys(ConfigLib.getValue("un"));
		driver.findElement(By.name("password")).sendKeys(ConfigLib.getValue("pwd"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 2, dataProvider = "eSignerUserData", dataProviderClass = DataProviders.class)
	public void verify_Add_User(String userCode, String userName, String userEmail, String pwd) {

		System.out.println("Tc 2 run");
		driver.findElement(By.xpath("//a[text()=' User Master'] ")).click();
		driver.findElement(By.id("btnNew")).click();

		driver.findElement(By.id("NV_USER_CODE")).sendKeys(userCode);
		driver.findElement(By.id("NV_USER_NAME")).sendKeys(userName);
		driver.findElement(By.id("NV_USER_EMAIL")).sendKeys(userEmail);
		driver.findElement(By.id("NV_USER_PWD")).sendKeys(pwd);
		driver.findElement(By.id("B_ACTIVE")).click();
		driver.findElement(By.id("btnAdd")).click();

		if (slib.isElementPresentBy(By.xpath("//div[contains(text(),'saved successfully')]"))) {
			String expectedMsg = "Record [" + userCode + "] saved successfully.";

			WebElement popupxpath = driver.findElement(By.xpath("//div[contains(text(),'saved successfully')]"));
			wait.until(ExpectedConditions.elementToBeClickable(popupxpath));

			String actualMsg = popupxpath.getText();
			Assert.assertEquals(actualMsg, expectedMsg);
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			System.out.println("User Added Succesfully");

			driver.findElement(By.xpath("//i[@class='fa fa-user-circle fa-2x']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

			driver.findElement(By.name("username")).sendKeys(userCode);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			String expectedresult = userName;

			String actualResult = driver.findElement(By.xpath("//h4[@class='font-16']")).getText();
			System.out.println("userCode:  " + userName);
			System.out.println("user name " + actualResult);
			Assert.assertEquals(expectedresult, actualResult);
		} else {
			System.out.println("User Already Exists");
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		}
	}

	@Test(priority = 3, dependsOnMethods = "verifyLogin", dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Add_Category(String catName, String CatUpload, String validFileName, String invalidFileName) {

		System.out.println("Tc 3 run");
		driver.findElement(By.xpath("//a[contains(text(),'Categories')]")).click();
		driver.findElement(By.id("btnNew")).click();
		driver.findElement(By.id("NV_CATEGORY_NAME")).sendKeys(catName);
		driver.findElement(By.id("spnButton")).click();

		// Pop up

		if (slib.isElementPresentBy(By.xpath("//div[contains(text(),'saved successfully')]"))) {

			WebElement popupxpath = driver.findElement(By.xpath("//div[contains(text(),'saved successfully')]"));
			wait.until(ExpectedConditions.elementToBeClickable(popupxpath));

			String actualresult = popupxpath.getText();
			System.out.println("abd  " + actualresult);
			String expectedResult = "Record [" + catName + "] saved successfully.";
			driver.findElement(By.xpath("//button[text()='OK']")).click();

			System.out.println("actualresult" + actualresult + "::" + "expectedResult" + expectedResult);
			Assert.assertEquals(actualresult, expectedResult);

			System.out.println("Add Catgeory verified succesfully");
		} else {
			System.out.println("Category Already Exists");
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		}

	}

	@Test(priority = 4, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_InvalidFile_Upload(String catName, String CatUpload, String validFileName,
			String invalidFileName) {
		
		System.out.println("Tc 4 run");
		driver.findElement(By.xpath("//span[contains(text(),'Unsigned Files')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Upload File')]")).click();
		slib.selectdropdown(driver.findElement(By.id("DocType")), CatUpload);
		driver.findElement(By.name("file_Uploader"))
				.sendKeys(ConfigLib.dirPath + "\\testData\\" + invalidFileName + "");
		driver.findElement(By.id("bttn_Upload")).click();

		String ExpectedResult = "1file(s) rejected due to file size. File name(s) :" + invalidFileName + "";
		String actualResult = driver.findElement(By.xpath("//div[contains(text(),'rejected due to file size')]"))
				.getText();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		sa.assertEquals(actualResult, ExpectedResult);

	}

	@Test(priority = 5, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Upload_Doc(String catName, String CatUpload, String validFileName, String invalidFileName) {

		System.out.println("Tc 5 run");
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

	@Test(priority = 6, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Sign_Doc(String catName, String CatUpload, String validFileName, String invalidFileName) {
		
		System.out.println("Tc 6 run");
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

	@Test(priority = 7, dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Downalod(String catName, String CatUpload, String validFileName, String invalidFileName) {

		System.out.println("Tc 7 run");
		WebElement downloadLink = driver
				.findElement(By.xpath("//td[contains(text(),'" + CatUpload + "')]/following-sibling::td[3]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(downloadLink));
		downloadLink.click();
	}

}