package testApp;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;
import com.indocs_CIDS.o1generic.DataProviders;

public class O1_Trade_PaymentMakerTest extends BaseAbstractTest {

	
	@Test (groups="Trade_Initiate_paymentGroup",
			priority = 1,
			dataProvider="initiatePayment_DP" , dataProviderClass = DataProviders.class)
	
		public void createPayment(String branch, String creditCurrency, 
			String clientRefNo,String vendorCode,String amount, String invoiceCount) 
	{
		driver.get(ConfigLib.getValue("cids_url"));
		lf.MakerLogin();
		tf.addpayment(branch,creditCurrency,  clientRefNo,vendorCode,amount, invoiceCount);
		
		
	}
	

	
	
}
