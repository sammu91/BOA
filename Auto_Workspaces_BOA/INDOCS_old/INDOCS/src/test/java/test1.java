import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test1 {

	 WebDriver driver;
    

//    @BeforeTest
//    public void setup(){
//        //Create firefox driver object
//         System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
//         driver = new ChromeDriver();
//         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//         driver.get("https://google.com");
//    }
 

    @Test(dataProvider="DP")
    public void testMethod(String author,String searchKey, String m) throws InterruptedException
    
    {
//        WebElement searchText = driver.findElement(By.name("q"));
//        //search value in google searchbox
//        searchText.sendKeys(searchKey);
//        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
//        Thread.sleep(3000);
//        String testValue = searchText.getAttribute("value");
//        System.out.println(testValue +"::::"+searchKey);
//        searchText.clear();
//        //Verify if the value in google search box is correct
//        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    	
    	
    	System.out.println(author +"::"+searchKey+"::"+m);
    }
    
   
    @DataProvider (name="DP")
	public Object[][] getCRMTestData(){
		Object data[][] = Test2.getTestData("Trade");
		return data;
	}
    
    
    
    
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" },
            {"sumit","test"}
        };

    }
    
}




