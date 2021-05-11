package testApp;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;

public class O4_OpsReviewMaker2Test extends BaseAbstractTest {
	
	

	@Test  //(dependsOnGroups="Trade_Approve_paymentGroup") 
	
	public void opsReviewMaker2Test(){
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.checkerLogin_INODCS();
		orm2fi.verify_ops_Review_Maker2();
		
		
	}

}
