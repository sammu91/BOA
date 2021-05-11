package o_04IAS.Features;	

import java.io.File;
import java.util.List;
import org.openqa.selenium.WebDriver;
import o_01IAS.generic.ExcelReadWriteUpdate;
import o_03IAS.steps.CISCustomerSteps;

public class CISMasterFeature {

	WebDriver driver;
	CISCustomerSteps ciscs;
	ExcelReadWriteUpdate erwu;

	public CISMasterFeature(WebDriver driver) {
		this.driver = driver;
		ciscs = new CISCustomerSteps(driver);
		erwu = new ExcelReadWriteUpdate();
	}

	
// Create and verify CIS feature
	public void VerifyCreateCis(String filepath, String unitName, String sheetName)
	{
		ciscs.redirectToCISmaster(unitName);

		File file = new File(filepath);
		
		List<Object> list = erwu.ReadExcelList(file, sheetName);
		
		for (int i = 1; i < list.size(); i++) 
		{
			List<String> data = (List<String>) list.get(i);
			
			ciscs.create_CIS_Customer(data);
			
			ciscs.Verify_Notifications(i, filepath,sheetName);
			
		}	
		
		}
	
}                                                            ����������~}~~!! "                YZY[��������������������������������XWVX        XZY[���������̎�a�D�;��<��Y�>��ʇ���������VWVX     "��������y�e�=��c�G���~����j�P�x�#�ܤj���������  ���������˚�@����n������������������~��r*��¢�����~~�����������C����������������������������H���l����������������� ���Y����������������R��L��N��=��P����������������� ���W����������������S��N��Q���S���l��������������������'������������������������������������������҄�����������!(��q{��������������������������������������!!""��������an��+��JV����������FS��AN��������������!!!!    [\\]������������DQ��*��'��BO��������������XXZZ        [[]^��������������������������������ZZ[[                ##$$�������������������ہ���!!""                                              