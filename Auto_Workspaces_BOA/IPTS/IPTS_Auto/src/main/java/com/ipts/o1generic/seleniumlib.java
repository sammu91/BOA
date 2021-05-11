package com.ipts.o1generic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumlib {

	WebDriver driver;
	JavascriptExecutor js;

	public seleniumlib(WebDriver driver) {

		this.driver = driver;
	}

	// Reset implicit wait before using explicit wait

	public void windowWait(WebDriver driver, int windowno) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify the time

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(windowno));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// Waits
	public void loginwait() {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.urlContains("Home"));
	}

	public void alertwait() {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void progresswait(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.attributeContains(ele, "style", "display: none"));

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

	public void removeAttribute(WebElement ele, String AttributeName) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + AttributeName + "')", ele);
	}

	public void setAttribute(WebElement element, String attName, String attValue) {
		js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attName, attValue);
		
	}
	

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
		js.executeScript("arguments[0].scrollTop = arguments[1];", ele, 500);
	}

	public void scrrolldownto_Div_HorzScroll(WebElement ele) {

		js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].scrollLeft = arguments[1];", ele, 500);
	}

	// Select Drop-Down////////////////////

	public void selectdropdown(WebElement ele, String txt) {

		Select sel = new Select(ele);
		sel.selectByVisibleText(txt);

	}

	/*********************************************************/

	// Handling Alerts
	// Alert Accept
	public void alertaccept() {

		driver.switchTo().alert().accept();
	}

	// Alert Text
	public String getAlertText() {

		String text = driver.switchTo().alert().getText();

		return text;
	}

	// Alert Present or not

	public boolean isAlertPresent() {
		try {
			alertwait();
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()

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

	public boolean isElementPresentNull_or_not(WebElement ele) {

		if (ele != null) {

			return true;

		} else {

			return false;
		}

	}

	public boolean isElementPresent_Isdispalyed(WebElement ele) {
		try {
			ele.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
	
	public boolean isElementPresent(By selector) {
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	    boolean returnVal;
	    try{
	        driver.findElement(selector);
	        returnVal=true;
	    } catch (NoSuchElementException e){
	        returnVal = false;
	    } finally {
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	    return returnVal;
	}
	
	/* ################## EXTRA METHODS ############################## */

	public String genRandomDigit(int digit, int max_digit) {
		Random rdm = new Random();
		String number = String.format("%0" + digit + "d", rdm.nextInt(max_digit));
		return number;
	}

}
