package o_05IAS.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import o_01IAS.generic.Baselib;
import o_01IAS.generic.ExcelRead;

public class GST_Uplaod extends Baselib {
	
	
	@Test(description="GST bulk Upload Test")
	public void gst_uplaod() throws InterruptedException {
		
		
		driver.findElement(By.id("btnLogin")).click();
		WebElement branch = driver.findElement(By.id("ddlUnit"));
		
		Select sel = new Select(branch);
		sel.selectByValue("6216");
		
		driver.findElement(By.id("hlnkGST")).click();
		
		driver.findElement(By.xpath("//a[text()='Import/Export']")).click();
		driver.findElement(By.linkText("GST Import")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_updFile")).sendKeys(Baselib.dirPath+"\\testdata\\GstImport.xlsx");
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLoad")).click();
		Thread.sleep(2000);
		ExcelRead eu = new ExcelRead(Baselib.dirPath+"\\IAS\\testdata\\GstImport.xlsx");
		
		eu.readdata("FX", 1, 1);
		
		Assert.assertEquals("28/03/2018", driver.findElement(By.xpath("//tr[@class='dgrow1']/td[2]")).getText());
		System.out.println("Transaction Date is verified");
		Assert.assertEquals("Trade", driver.findElement(By.xpath("//tr[@class='dgrow1']/td[3]")).getText());
		System.out.println("Department is verified");
	}

}
