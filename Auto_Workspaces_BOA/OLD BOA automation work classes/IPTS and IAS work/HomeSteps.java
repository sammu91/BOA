package o_03IAS.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import o_02IAS.PageObjects.HomePage;

public class HomeSteps {


	WebDriver driver;
	HomePage hp;
	
	
	public HomeSteps(WebDriver driver) {
		
		this.driver= driver;
		hp= new HomePage(driver);
	}

	// Branch selection on home page	
	
		public void SelectUnitBranch(String unitName) {

			Select sel = new Select(hp.getunitdrpdwn());
			sel.selectByVisibleText(unitName);

		}
			
	public void clickGlobalMaster() {
		
		hp.getGlobalMasterBTN().click();
	}
	
	public void clickGSTBtn() {
		
		hp.getGSTBTN().click();
	}
			
}
                                                      