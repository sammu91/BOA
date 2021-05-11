package testApp;

import org.testng.annotations.Test;

import com.indocs.BaseAbstarct.BaseAbstractTest;
import com.indocs_CIDS.o1generic.ConfigLib;

public class O3_OpsReviewMakerTest extends BaseAbstractTest {

	@Test  //(dependsOnGroups="Trade_Approve_paymentGroup") 
	
	public void opsReviewMakerTest(){
		
		driver.get(ConfigLib.getValue("indocs_url"));
		lfi.makerLogin_INODCS();
		ormfi.verify_ops_Review_Maker();
		
		
	}
	

	
	
}
