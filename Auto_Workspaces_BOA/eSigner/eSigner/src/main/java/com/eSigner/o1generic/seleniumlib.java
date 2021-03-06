package com.eSigner.o1generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	public void visiblewait(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ele));
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

	public boolean isElementPresentBy(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
