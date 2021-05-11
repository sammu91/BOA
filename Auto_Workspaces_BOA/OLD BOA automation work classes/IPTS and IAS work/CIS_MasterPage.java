package o_02IAS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CIS_MasterPage {

	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
	private WebElement add_CISbtn;
	
	

	public CIS_MasterPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	
	public WebElement getAdd_CISbtn() {
		return add_CISbtn;
	}
}
