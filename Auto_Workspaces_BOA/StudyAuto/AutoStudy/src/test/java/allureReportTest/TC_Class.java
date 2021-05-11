package allureReportTest;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;

public class TC_Class {
	
	public  WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		
	}
	
	
	@Test (description= "tetng desc of TC_1")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This is allure desc of TC_1")
	@Story("Stroy Name = Story of TC_1 ")
	@Stories (@Story("Story 1 of stroies"))
	
	public void TC_1() {
		
		String title = driver.getTitle();
		System.out.println("Title of the page is"+ title);
		steps();
	}
	
	

	
	@Step("Executing step fromallure for tC_1")
	public void steps() {
		
		System.out.println("Steps method executes");
	}
	
	
	@AfterMethod
	public void tearDownDriver() {
		driver.quit();
	}
}








