package com.eSigner.o1generic;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestNgListener implements ISuiteListener {


	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ISuite arg0) {
		WebDriver driver = BrowserFactory.launch(ConfigLib.getValue("browserName"));
		Driver.setDriver(driver);
	}

	

}
