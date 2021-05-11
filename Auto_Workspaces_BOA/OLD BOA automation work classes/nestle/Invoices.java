package Nestle;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import o_01IAS.generic.Baselib;
import o_01IAS.generic.ExcelRead;

public class Invoices {

	public static void main(String[] args)  {

		//String sheetName = "Sheet1";
		String URL = "http://10.1.40.102:8015";
		String Location="1720";
		
		// String sheetName="pre19";
		// String URL= "http://10.1.20.116:8019/";

		String filepath = Baselib.dirPath + "./testdata/NestleData.xlsx";
		ExcelRead eu = new ExcelRead(filepath);
		

//		 System.setProperty("webdriver.chrome.driver", Baselib.dirPath +
//		 "./exe/chromedriver.exe");
//		 WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.ie.driver", Baselib.dirPath + "/exe/IEDriverServer32.exe");
		WebDriver driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);

		driver.findElement(By.id("cmdLogon")).click();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("alert not present");

		}

		// Side menu
		driver.findElement(By.xpath(" //a[contains(text(),'Transaction')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Invoices')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();

		// Select Location
		driver.findElement(By.id("select2-ContentPlaceHolder1_ddlLocation-container")).click();
		driver.findElement(By.xpath("//li[contains(@id,'"+Location+"')]")).click();

	
		
// Multpile invoice loop		
		for (int j = 1; j <= 2; j++) {
			
		
		try {
			driver.findElement(By.id("ContentPlaceHolder1_imgAdd")).click();
		} catch (Exception e) {
			driver.findElement(By.id("ContentPlaceHolder1_imgAdd")).click();
			System.out.println("catch block executed");
		}

		// Invoice Form
		// calendar
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtDate']")).clear();
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtDate']")).sendKeys("02/07/2019");
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtOrderDate']")).clear();
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtOrderDate']")).sendKeys("02/07/2019");

		// Ref no.
		driver.findElement(By.id("ContentPlaceHolder1_txtOrderRefNo")).sendKeys("123456");

		// Payment mode
		driver.findElement(By.id("select2-ContentPlaceHolder1_ddlPayMode-container")).click();
		driver.findElement(By.xpath("//li[text()='CA - Cash      ']")).click();

		// Customer code
		driver.findElement(By.id("select2-ContentPlaceHolder1_ddlCustomerCode-container")).click();
		driver.findElement(By.xpath("//li[text()='1022979 - R B Agencies']")).click();

		// custcode time starts
		long cutstartime = System.currentTimeMillis();
		WebElement custcode = driver.findElement(By.id("ContentPlaceHolder1_lblFCustName"));
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(custcode, "")));
		long cutstoptime = System.currentTimeMillis();
		long totalcusttime = (cutstoptime - cutstartime) / 1000;
		System.out.println("time taken to get customer code: " + totalcusttime + " seconds");
		// 1
		eu.updateSpecificCell(1, totalcusttime + " second(s)", 2, "Sheet"+j);

		// ship delivery
		driver.findElement(By.id("select2-ContentPlaceHolder1_ddlShipDelivTo-container")).click();
		driver.findElement(By.xpath("//li[text()='1022979 - R B Agencies']")).click();

		// shipcode time starts
		long shipstartime = System.currentTimeMillis();
		WebElement shipname = driver.findElement(By.id("ContentPlaceHolder1_lblTCustName"));
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(shipname, "")));
		long shipstoptime = System.currentTimeMillis();
		long totalshiptime = (shipstoptime - shipstartime) / 1000;
		System.out.println("time taken to get ship code: " + totalshiptime + " seconds");
		// 2
		eu.updateSpecificCell(1, totalshiptime + " second(s)", 3, "Sheet"+j);

		// carrier
		driver.findElement(By.id("select2-ContentPlaceHolder1_ddlCarrier-container")).click();
		driver.findElement(By.xpath("//li[text()='100204543 - ABC India Ltd']")).click();

		// LR/RR no.
		driver.findElement(By.id("ContentPlaceHolder1_txtLRRRNo")).sendKeys("0123456789");

		// Vehicle no.
		driver.findElement(By.id("ContentPlaceHolder1_txtVehNo")).sendKeys("vh123456");

		// channel
		driver.findElement(By.id("select2-ContentPlaceHolder1_ddlChannel-container")).click();
		driver.findElement(By.xpath("//li[text()='01 - Retail']")).click();

		// Grid
		// ******************************************************************************************************
		// mat code time starts

		long matcodestart = System.currentTimeMillis();
		WebElement Matcodopt = driver.findElement(By.xpath("//span[contains(@id,'Material-container')]"));
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(Matcodopt, "")));
		long matcodestoptime = System.currentTimeMillis();
		long totalmatcodetime = (matcodestoptime - matcodestart) / 1000;
		System.out.println("Time taken to get material code: " + totalmatcodetime + " seconds");
		// 3
		eu.updateSpecificCell(1, totalmatcodetime + " second(s)", 4, "Sheet"+j);

		
		int rowcount = eu.getRowCount("Sheet"+j);
		
		
		
// Grid	Loop	
		for (int i = 1; i <= rowcount; i++)
		{
			
		
			driver.findElement(By.xpath("//span[contains(@id,'Material-container')]")).click();
			
			String materialcode = eu.readdata("Sheet"+j, i, 1);
			WebElement Matcode = driver.findElement(By.xpath("//li[text()='" + materialcode + "']"));
			wait.until(ExpectedConditions.elementToBeClickable(Matcode));
			
			Matcode.click();

			// MRP time
			long MRPstart = System.currentTimeMillis();

			wait.until(ExpectedConditions.not(ExpectedConditions
					.textToBePresentInElement(driver.findElement(By.xpath("//select[contains(@id,'MRP')]")), "")));

			long MRPstoptime = System.currentTimeMillis();
			long totalMRPtime = (MRPstoptime - MRPstart) / 1000;
			System.out.println("time taken to get MRP : " + totalMRPtime + " seconds");
			// 4
			eu.updateSpecificCell(i, totalMRPtime + " second(s)", 5, "Sheet"+j);
			new Select(driver.findElement(By.xpath("//select[contains(@id,'MRP')]"))).selectByIndex(1);

			// Batch time
			long Batchstart = System.currentTimeMillis();
			WebElement batch = driver.findElement(By.xpath("//select[contains(@id,'Batch')]"));
			wait.until(ExpectedConditions.not(ExpectedConditions
					.textToBePresentInElement(driver.findElement(By.xpath("//select[contains(@id,'Batch')]")), "")));
			long batchstoptime = System.currentTimeMillis();
			long totalbatchtime = (batchstoptime - Batchstart) / 1000;
			System.out.println("time taken to get Batch : " + totalbatchtime + " seconds");
			// 5
			eu.updateSpecificCell(i, totalbatchtime + " second(s)", 6, "Sheet"+j);
			new Select(driver.findElement(By.xpath("//select[contains(@id,'Batch')]"))).selectByIndex(1);

			// Quantity (and operator xpath)
			driver.findElement(By.xpath("//input[contains(@id,'Q1') and @class='txtbox']")).sendKeys("1");
			driver.findElement(By.xpath("//input[contains(@id,'Q2') and contains(@class,'txtbox')]")).click();

			// Levies time
			long Leviesstarttime = System.currentTimeMillis();
			wait.until(ExpectedConditions.not(ExpectedConditions
					.textToBePresentInElement(driver.findElement(By.xpath("//input[contains(@id,'Levies')]")), "")));
			long Leviesstoptime = System.currentTimeMillis();
			long totalLeviestime = (Leviesstoptime - Leviesstarttime) / 1000;
			System.out.println("Time taken to get Levies : " + totalLeviestime + " seconds");
			// 6
			eu.updateSpecificCell(i, totalLeviestime + " second(s)", 7, "Sheet"+j);

			// Add
			driver.findElement(By.xpath("//input[contains(@id,'btnAdd')]")).click();
			System.out.println("add btn clicked");
			long addDataStartTime = System.currentTimeMillis();

			try {
				wait.until(ExpectedConditions.attributeToBe(
						driver.findElement(By.xpath("//input[contains(@id,'Q1') and @class='txtbox']")), "value", "0"));
			} catch (Exception e) {
				wait.until(ExpectedConditions.attributeToBe(
						driver.findElement(By.xpath("//input[contains(@id,'Q1') and @class='txtbox']")), "value", "0"));
				System.out.println("catch executed");
			}

			long addDataStopTime = System.currentTimeMillis();
			long totaladdDatatime = (addDataStopTime - addDataStartTime) / 1000;
			System.out.println("Time taken to add single record : " + totaladdDatatime + " seconds");
			// 7
			eu.updateSpecificCell(i, totaladdDatatime + " second(s)", 8, "Sheet"+j);

		}

		
		
		
		
		
// screenshot
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(Baselib.dirPath + "\\screenshots\\" + sdf.format(new Date()) + ".png");

		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.findElement(By.id("ContentPlaceHolder1_btnSave")).click();
		long saveInvoiceStart = System.currentTimeMillis();

		WebElement okbtn = driver.findElement(By.id("ContentPlaceHolder1_btnOrderOk"));
		wait.until(ExpectedConditions.visibilityOf(okbtn));
		okbtn.click();

		wait.until(ExpectedConditions.alertIsPresent());
		Alert invoiceAlert = driver.switchTo().alert();
		String invoiceno = invoiceAlert.getText();
		invoiceAlert.accept();
		long saveInvoiceStopTime = System.currentTimeMillis();
		long totalAddInvoiceTime = (saveInvoiceStopTime - saveInvoiceStart) / 1000;
		System.out.println("Time taken to add single record : " + totalAddInvoiceTime + " seconds");
		// 7
		eu.updateSpecificCell(1, invoiceno + " ::Time Taken: = " + totalAddInvoiceTime + " second(s)", 9, "Sheet"+j);

	}
	}
}
