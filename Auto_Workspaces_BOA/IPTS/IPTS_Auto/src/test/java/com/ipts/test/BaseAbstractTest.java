package com.ipts.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.ipts.o1generic.BrowserFactory;
import com.ipts.o1generic.ConfigLib;
import com.ipts.o1generic.Driver;
import com.ipts.o3features.Payable_Import_Features;
import com.ipts.o3features.IPTS_Cycle_Features;
import com.ipts.o3features.LoginFeatures;

public abstract class BaseAbstractTest {
	public WebDriver driver; // Global driver
	// public static EventFiringWebDriver driver; //global driver
	
	public LoginFeatures lf;
	public Payable_Import_Features pif;
	public IPTS_Cycle_Features iptscf;

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.launch(ConfigLib.getValue("browserName"));
		Driver.setDriver(driver);
		// this.driver= Driver.getDriver();
		
		lf= new LoginFeatures(driver);
		pif= new Payable_Import_Features(driver);
		iptscf=new IPTS_Cycle_Features(driver);
		
	}

	@BeforeMethod
	public void preCondition() {

		driver = Driver.getDriver();
		// driver=new EventFiringWebDriver(Driver.getDriver());
		// driver.register(new TestNgListener());
		
		driver.get(ConfigLib.getValue("url"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//
//	 @AfterClass
//	 public void postCondition()
//	 {
//	 driver.close();
//	 }
}