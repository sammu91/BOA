package selnium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wibdohanldes {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://fiplokiis:7880/Entry/Index");
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
//		driver.get("https://www.google.com/");
		
		System.out.println(driver.getWindowHandles());
	}

}
