package com.indocs.BaseAbstarct;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.indocs_CIDS.o1generic.BrowserFactory;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.Driver;
import com.indocs_CIDS.o3features.EXPORT_CIDS_Checker_Features;
import com.indocs_CIDS.o3features.EXPORT_CIDS_InitiateExportMkr_Features;
import com.indocs_CIDS.o3features.TRADE_CIDS_InitiatePaymentMaker_Features;
import com.indocs_CIDS.o3features.CIDS_Login_Feature;
import com.indocs_CIDS.o3features.TRADE_CIDS_PaymentFundingChecker_Features;
import com.indocs_CIDS.o3features.TRADE_CIDS_PaymentFunding_Features;
import com.indocs_CIDS.o3features.TRADE_CIDS_Paymentchecker_Feature;
import com.indocs_CIDS.o3features.TRSRY_CIDS_InitiatePaymentMaker_Features;
import com.indocs_CIDS.o3features.TRSRY_CIDS_PaymentFundingChecker_Features;
import com.indocs_CIDS.o3features.TRSRY_CIDS_PaymentFunding_Features;
import com.indocs_CIDS.o3features.TRSRY_CIDS_Paymentchecker_Feature;
import com.indocs_CIDS.o3features.EXPORT_INDOCS_OpsRevieweChecker_Features;
import com.indocs_CIDS.o3features.EXPORT_INDOCS_OpsReviewerMaker_Features;
import com.indocs_CIDS.o3features.INDOCS_Login_Feature;
import com.indocs_CIDS.o3features.TRADE_INDOCS_OpsReviewChkr_Features;
import com.indocs_CIDS.o3features.TRADE_INDOCS_OpsReviewerMaker2_Features;
import com.indocs_CIDS.o3features.TRADE_INDOCS_OpsReviewerMaker_Features;
import com.indocs_CIDS.o3features.TRADE_INDOCS_PaymentRegister_Maker_Checker_Features;
import com.indocs_CIDS.o3features.TRADE_INDOCS_SDSprocessing_Aries_Checker_Features;
import com.indocs_CIDS.o3features.TRADE_INDOCS_SDSprocessing_Maker_Features;
import com.indocs_CIDS.o3features.TRSRY_INDOCS_OpsRevieweChecker_Features;
import com.indocs_CIDS.o3features.TRSRY_INDOCS_OpsReviewerMaker_Features;
import com.indocs_CIDS.o3features.TRSRY_INDOCS_PaymentRegister_Maker_Checker_Features;

public abstract class BaseAbstractTest {
	public WebDriver driver; // Global driver
	// public static EventFiringWebDriver driver; //global driver
	public CIDS_Login_Feature lf;
	public TRADE_CIDS_InitiatePaymentMaker_Features tf;
	public TRADE_CIDS_Paymentchecker_Feature pcf;
	public INDOCS_Login_Feature lfi;
	public TRADE_INDOCS_OpsReviewerMaker_Features ormfi;
	public TRADE_INDOCS_OpsReviewerMaker2_Features orm2fi;
	public TRADE_INDOCS_OpsReviewChkr_Features orcfi;
	public TRADE_CIDS_PaymentFunding_Features pfmf;
	public TRADE_CIDS_PaymentFundingChecker_Features pfcf;
	public TRSRY_CIDS_InitiatePaymentMaker_Features trf;
	public TRSRY_CIDS_Paymentchecker_Feature pcft;
	public TRSRY_INDOCS_OpsReviewerMaker_Features ormfti;
	public TRSRY_INDOCS_OpsRevieweChecker_Features orcfti;
	public TRSRY_CIDS_PaymentFunding_Features pfmft;
	public TRSRY_CIDS_PaymentFundingChecker_Features pfcft;
	public EXPORT_CIDS_InitiateExportMkr_Features ief;
	public EXPORT_CIDS_Checker_Features ecf;
	public EXPORT_INDOCS_OpsReviewerMaker_Features eormfi;
	public EXPORT_INDOCS_OpsRevieweChecker_Features eorcf;
	public TRADE_INDOCS_SDSprocessing_Maker_Features spmfi;
	public TRADE_INDOCS_SDSprocessing_Aries_Checker_Features spacfi;
	public TRADE_INDOCS_PaymentRegister_Maker_Checker_Features prmcfi;
	public TRSRY_INDOCS_PaymentRegister_Maker_Checker_Features tprmcfi;
	
	
	

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.launch(ConfigLib.getValue("browserName"));
		Driver.setDriver(driver);
		// this.driver= Driver.getDriver();
		lf = new CIDS_Login_Feature(driver);
		tf = new TRADE_CIDS_InitiatePaymentMaker_Features(driver);
		pcf = new TRADE_CIDS_Paymentchecker_Feature(driver);
		ormfi = new TRADE_INDOCS_OpsReviewerMaker_Features(driver);
		lfi = new INDOCS_Login_Feature(driver);
		orm2fi = new TRADE_INDOCS_OpsReviewerMaker2_Features(driver);
		orcfi = new TRADE_INDOCS_OpsReviewChkr_Features(driver);
		pfmf = new TRADE_CIDS_PaymentFunding_Features(driver);
		pfcf = new TRADE_CIDS_PaymentFundingChecker_Features(driver);
		trf = new TRSRY_CIDS_InitiatePaymentMaker_Features(driver);
		pcft = new TRSRY_CIDS_Paymentchecker_Feature(driver);
		ormfti = new TRSRY_INDOCS_OpsReviewerMaker_Features(driver);
		orcfti = new TRSRY_INDOCS_OpsRevieweChecker_Features(driver);
		pfmft = new TRSRY_CIDS_PaymentFunding_Features(driver);
		pfcft = new TRSRY_CIDS_PaymentFundingChecker_Features(driver);
		ief = new EXPORT_CIDS_InitiateExportMkr_Features(driver);
		ecf= new EXPORT_CIDS_Checker_Features(driver);
		eormfi= new EXPORT_INDOCS_OpsReviewerMaker_Features(driver);
		eorcf = new EXPORT_INDOCS_OpsRevieweChecker_Features(driver);
		spmfi = new TRADE_INDOCS_SDSprocessing_Maker_Features(driver);
		spacfi= new TRADE_INDOCS_SDSprocessing_Aries_Checker_Features(driver);
		prmcfi = new TRADE_INDOCS_PaymentRegister_Maker_Checker_Features(driver);
		tprmcfi = new TRSRY_INDOCS_PaymentRegister_Maker_Checker_Features(driver);
	}

	@BeforeMethod
	public void preCondition() {

		driver = Driver.getDriver();
		// driver=new EventFiringWebDriver(Driver.getDriver());
		// driver.register(new TestNgListener());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// @AfterClass
	// public void postCondition()
	// {
	// driver.close();
	// }
}