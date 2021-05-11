package selnium_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Download webdriver manager from maven dependency not offcial created by some tester

public class WebdriverManager_Test {

	public static void main(String[] args) {

		
//		Chrome
//		WebDriverManager.chromedriver().setup();
		
//		WebDriver driver = new ChromeDriver();
//		driver.close();
//		
		
//		WebDriverManager.iedriver().setup();
		
//		WebDriver driver2 = new  InternetExplorerDriver();
//		driver2.close();
		
		
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver3 = new  FirefoxDriver();
		driver3.close();
	}

}
