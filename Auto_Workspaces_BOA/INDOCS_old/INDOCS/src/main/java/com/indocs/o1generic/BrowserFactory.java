package com.indocs.o1generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class BrowserFactory 
{
	public static WebDriver launch(String browserName)
	{
		WebDriver driver=null;
		
		
			if (browserName.equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver", ConfigLib.dirPath+"\\exefiles\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			
			else if(browserName.equalsIgnoreCase("IE")) 
			{
				System.setProperty("webdriver.ie.driver", ConfigLib.dirPath+"\\exefiles\\IEDriverServer32.exe");
				driver=new InternetExplorerDriver();
			}
		
		return driver;
	}
}
