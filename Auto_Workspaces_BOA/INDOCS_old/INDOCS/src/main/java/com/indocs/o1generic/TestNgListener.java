package com.indocs.o1generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class TestNgListener implements ISuiteListener, ITestListener, WebDriverEventListener {

	public static int executionCount, passCount, failCount, skipCount = 0;
	public long startTime;
	Logger log;

	// Suite starts
	
	public void onStart(ISuite arg0) {

		// Log 4J setup
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		System.setProperty("ttccFilePath",
				ConfigLib.dirPath + "\\reports\\logs\\Report" + sdf.format(new Date()) + ".log");
		
		
		System.setProperty("htmlFilePath",
				ConfigLib.dirPath + "\\reports\\log4jhtml\\Report" + sdf.format(new Date()) + ".html");
		

		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass());

		log.info("Suite execution starts " + new Date());

		// Getting and setting driver instance
		WebDriver driver = BrowserFactory.launch(ConfigLib.getValue("browserName"));
		Driver.setDriver(driver);

		startTime = System.currentTimeMillis();
	}

	
	public void onFinish(ISuite arg0) {

		long endTime = System.currentTimeMillis();
		double totalTime = (endTime - startTime) / 1000;
		// Driver.getDriver().quit();
		log.info("Suite Execution ends " + new Date());
		log.info("Total execution time: " + totalTime + "seconds");

	}

	// ItestListner Methods

	
	public void onTestStart(ITestResult result) {

		executionCount++;
		log.info(result.getName() + " script execution starts " + new Date());
	}

	public void onTestSuccess(ITestResult result) {
		passCount++;
		log.info(result.getName() + " script is passed");
	}

	public void onTestFailure(ITestResult result) {
		failCount++;
		log.error(result.getName() + " script is failed");
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				ConfigLib.dirPath + "\\screenshots\\" + result.getName() + sdf.format(new Date()) + ".png");

		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("Screenshot has been taken");
	}

	public void onTestSkipped(ITestResult result) {
		skipCount++;
		log.info(result.getName() + " script is skipped");
	}

	public void onFinish(ITestContext arg0) {}
	public void onStart(ITestContext arg0) {}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}

	
// Web driver Methods	
	
	
	public void onException(Throwable t, WebDriver arg1) 
	{
		log.fatal(t.getMessage());
	}
	
	public void afterAlertAccept(WebDriver arg0) {	
	}

	
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
