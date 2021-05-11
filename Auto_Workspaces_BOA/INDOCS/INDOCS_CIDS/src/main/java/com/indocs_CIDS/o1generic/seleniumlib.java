package com.indocs_CIDS.o1generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indocs_CIDS.o2pageobjects.CIDS_CommonPage;

public class seleniumlib {

	WebDriver driver;
	CIDS_CommonPage cp;
	JavascriptExecutor js;

	public seleniumlib(WebDriver driver) {

		this.driver = driver;
		cp = new CIDS_CommonPage(driver);
	}

	// Waits
	
	public void iWait(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public void loginwait() {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.urlContains("Home"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void alertwait() {

		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void progresswait() {

		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.attributeContains(cp.getProgress(), "style", "display: none"));

	}

	public void clickablewait(WebElement ele) {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void visiblewait(WebElement ele) {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ele));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
// Java script methods ##########################################	
	public void scrrolldown() {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	
	public void scrrolldowntoElement(WebElement ele) {

		js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

	}
	
	
	public void scrrolldownto_Div_VerticalScroll(WebElement ele) {
		
		js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].scrollTop = arguments[1];",ele, 500);
	}
	
	public void scrrolldownto_Div_HorzScroll(WebElement ele) {
		
		js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].scrollLeft = arguments[1];",ele, 500);
	}
	
	
	//JS click
	public void javascriptClick(WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", ele);
	}
	
	/// Select dropdwon////////////////////

	public void selectdropdown(WebElement ele, String txt) {

		Select sel = new Select(ele);
		sel.selectByVisibleText(txt);

	}

	/// Alert accept ///////
	public void alertaccept() {

		driver.switchTo().alert().accept();
	}

	public String getAlertText() {

		String text = driver.switchTo().alert().getText();

		return text;
	}

	/*********************************************************/
	public void clickChkOrRadio(WebElement ele) {

		if (ele.isSelected() != true) {
			ele.click();
		}

	}

// To check element dispalyed	
	public boolean isDisplayed(WebElement ele) {

		boolean flag = ele.isDisplayed();

		return flag;

	}

// Check element present or not	
	
	public boolean isElementPresentPOM(WebElement ele) {

		if (ele != null) {

			return true;
			

		} else {

			return false;
		}

	}

	public boolean isElementPresent(WebElement ele) {
		try {
			ele.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
