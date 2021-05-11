package o_01IAS.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Baselib {

	public static String dirPath = System.getProperty("user.dir");
	public static String osName = System.getProperty("os.name");

	public WebDriver driver;

	@BeforeMethod
	public void browserlaunch() {

		driver = BrowserFactory.Browserlaunch("ie");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.1.20.116:8099/IAS-FIU");

	}

	@AfterMethod
	public void browserclose() {

		System.out.println("browser close");
//		 driver.close();

	}

}
