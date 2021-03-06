package com.indocs.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.indocs.o1generic.BrowserFactory;
import com.indocs.o1generic.ConfigLib;
import com.indocs.o1generic.Driver;
import com.indocs.o4features.LoginFeature;


public abstract class BaseAbstractTest 
{
	public static WebDriver driver;  //Global driver
	//public static EventFiringWebDriver driver;  //global driver
	public LoginFeature lf;
	
	
	@BeforeClass
	public void setUp()
	{
		lf=new LoginFeature();
		
	}
	
	
	
	@BeforeMethod
	public void preCondition()
	{
		driver=Driver.getDriver();
		//driver=new EventFiringWebDriver(Driver.getDriver());
		//driver.register(new TestNgListener());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}