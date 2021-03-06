package com.esigner.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.eSigner.o1generic.BrowserFactory;
import com.eSigner.o1generic.ConfigLib;
import com.eSigner.o1generic.seleniumlib;

public class BaseClass {

	public WebDriver driver;
	seleniumlib slib;
	WebDriverWait wait;
	SoftAssert sa;

	@BeforeClass
	public void initialize() {

		driver=BrowserFactory.launch(ConfigLib.getValue("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ConfigLib.getValue("url"));
		slib = new seleniumlib(driver);
		wait = new WebDriverWait(driver, 10);
		sa = new SoftAssert();

	}

//	@AfterClass
//	public void tearDown() {
//		driver.close();
//	}

}
