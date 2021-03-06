package com.esigner.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.eSigner.o1generic.ConfigLib;
import com.eSigner.o1generic.DataProviders;

public class TC_1_AddCategory extends BaseClass {

	@Test(priority = 1)
	public void verifyLogin() {

		driver.findElement(By.name("username")).sendKeys(ConfigLib.getValue("un"));
		driver.findElement(By.name("password")).sendKeys(ConfigLib.getValue("pwd"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 2, dependsOnMethods = "verifyLogin", dataProvider = "eSignerData", dataProviderClass = DataProviders.class)
	public void verify_Add_Category(String catName, String CatUpload, String validFileName, String invalidFileName) {

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
			sa.assertEquals(actualresult, expectedResult);

			System.out.println("Add Catgeory verified succesfully");
		} else {
			System.out.println("Category Already Exists");
			driver.findElement(By.xpath("//button[text()='OK']")).click();
		}
	}

}