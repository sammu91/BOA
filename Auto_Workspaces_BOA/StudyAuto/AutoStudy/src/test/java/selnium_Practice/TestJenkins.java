package selnium_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJenkins {

	@Test
	public void TC_1() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println("Google test is done");
	}
	
	@Test
	public void TC_2() {
		
		System.out.println("Test 2 is executed");
	}

	
}
