package com.esigner.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eSigner.o1generic.ConfigLib;
import com.eSigner.o1generic.DataProviders;

public class TC_3_AddUser extends BaseClass {

	@Test(priority = 1)
	public void verifyLogin() {

		driver.findElement(By.name("username")).sendKeys(ConfigLib.getValue("un"));
		driver.findElement(By.name("password")).sendKeys(ConfigLib.getValue("pwd"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 2, dataProvider = "eSignerUserData", dataProviderClass = DataProviders.class)
	public void verify_Add_User(String userCode, String userName, String userEmail, String pwd) {

		driver.findElement(By.xpath("//a[text()=' User Master'] ")).click();
		driver.findElement(By.id("btnNew")).click();

		driver.findElement(By.id("NV_USER_CODE")).sendKeys(userCode);
		driver.findElement(By.id("NV_USER_NAME")).sendKeys(userName);
		driver.findElement(By.id("NV_USER_EMAIL")).sendKeys(userEmail);
		driver.findElement(By.id("NV_USER_PWD")).sendKeys(pwd);
		driver.findElement(By.id("B_ACTIVE")).click();
		driver.findElement(By.id("btnAdd")).click();

		String expectedMsg = "Record [" + userCode + "] saved successfully.";
		String actualMsg = driver.findElement(By.xpath("//div[contains(text(),'saved successfully.')]")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("User Added Succesfully");

		driver.findElement(By.xpath("//i[@class='fa fa-user-circle fa-2x']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

		driver.findElement(By.name("username")).sendKeys(userCode);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String expectedresult = userCode;
		String actualResult = driver.findElement(By.xpath("//h4[@class='font-16']")).getText();
		Assert.assertEquals(expectedresult, actualResult);
	}

}