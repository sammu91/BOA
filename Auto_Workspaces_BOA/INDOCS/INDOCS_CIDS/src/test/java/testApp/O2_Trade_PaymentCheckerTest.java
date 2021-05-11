package testApp;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;

public class O2_Trade_PaymentCheckerTest extends BaseAbstractTest {
	
	
	@Test (groups="Trade_Approve_paymentGroup",dependsOnGroups="Trade_Initiate_paymentGroup")
	public void verifyApprovePayment(String branch, String creditCurrency, String clientRefNo, String vendorCode,
			String amount, String invoiceCount,String fundType,String custAccount) {

		System.out.println("approve payment run");
		driver.get(ConfigLib.getValue("cids_url"));
		lf.checkerLogin();
		pcf.approvePayment(clientRefNo);
		System.out.println("approve payment close");
		
	}

}
