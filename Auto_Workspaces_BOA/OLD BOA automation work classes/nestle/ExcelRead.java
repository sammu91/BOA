package o_01IAS.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelRead {

	String filepath;
	public ExcelRead(String filepath){
		this.filepath=filepath;
	}
	
	
	public String readdata(String sheet,int row,int cell)  
	{
		
		String value=null;
		Workbook wb = null;
		
		try {
			
			File fil = new File(filepath);
			FileInputStream fis=new FileInputStream(fil);
			wb=XSSFWorkbookFactory.create(fis);
			
			Sheet sh = wb.getSheet(sheet);
			Row rw = sh.getRow(row);
			Cell cl=rw.getCell(cell);
			
			switch (cl.getCellType()) 
			{
			case STRING :
			value = cl.getStringCellValue();
				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cl)) 
				{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyy");
				value=sdf.format(cl.getDateCellValue());
				}
				else {
				
				int numvalue = (int)cl.getNumericCellValue();
				value = Integer.toString(numvalue);	
				}
				break;
			case BOOLEAN:
			value= Boolean.toString(cl.getBooleanCellValue());
			default:
				System.out.println("cell format is not matching");
				break;
			}		
			
		} catch (EncryptedDocumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch (IOException e) {
			System.out.println(e.getClass().getSimpleName());
		}
	
	return value;	
		
	}	
	
//********************************WRITE/Update DATA in excel**************************************************************//	
	public void updateSpecificCell(int row_No, String status, int cell_No,String sheetName) {
        try {
        	System.out.println("updateSpecificCell called");
        	
            FileInputStream inputStream = new FileInputStream( new File(filepath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(row_No);
            if (row == null) {
            	row = sheet.createRow(row_No);
            }
            
            Cell cell2Update = row.getCell(cell_No);
            
            if (cell2Update == null) {
                cell2Update = row.createCell(cell_No);
            }
            cell2Update.setCellValue(status);

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(filepath);
            workbook.write(outputStream);
            outputStream.close();

        } catch (Exception ex) {
        	System.out.println(ex);
            ex.printStackTrace();
        }
    }
	
	
//******************************Get Row Count method************************************************************//		
	
	// 1. Get sheet method		
		public int getRowCount(String sheetname)
			{
				int rowCount=0;
				
				try
				{
					FileInputStream fis = new FileInputStream(new File(filepath));
					Workbook wb = WorkbookFactory.create(fis);
					Sheet sh = wb.getSheet(sheetname);
					 rowCount = sh.getLastRowNum();
					
					
				}
				catch(EncryptedDocumentException | IOException e)
				{
					
				}
				
				return rowCount;
			}
}
