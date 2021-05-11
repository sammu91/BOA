
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Inderjeets
 */
public class ExcelReadWriteUpdate {

    public void WriteExcelDemo(List<Object[]> list) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

//        List<Object[]> list = Arrays.asList(values);
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ID", "NAME", "LASTNAME", "STATUS"});

        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            data.put(Integer.toString(2 + i), new Object[]{row[0], row[1], row[2]});
        }

        //This data needs to be written (Object[])
//        Map<String, Object[]> data = new TreeMap<String, Object[]>();
//        data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
//        data.put("2", new Object[]{1, "Amit", "Shukla"});
//        data.put("3", new Object[]{2, "Lokesh", "Gupta"});
//        data.put("4", new Object[]{3, "John", "Adwards"});
//        data.put("5", new Object[]{4, "Brian", "Schultz"});
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("report.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("report.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List ReadExcel(File file) {
        List<Object> list = new ArrayList<Object>();
        try {
            FileInputStream fis = new FileInputStream(file);
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int r = 0;

            while (rowIterator.hasNext()) {
                List<String> Ll = new LinkedList<String>();
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int cellcount = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            Ll.add(cellcount, Double.toString(cell.getNumericCellValue()));
                            System.out.print(cell.getNumericCellValue() + " ");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            Ll.add(cellcount, cell.getStringCellValue());
                            System.out.print(cell.getStringCellValue() + " ");
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            Ll.add(cellcount, "");
                            System.out.print(" ");
                            break;
                    }
                    cellcount++;
                }
                System.out.println("");
                list.add(r, Ll);
                r++;
            }
            fis.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List ReadExcelList(File file) {
        List<Object> list = new ArrayList<Object>();
        try {
            FileInputStream fis = new FileInputStream(file);
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int r = 0;

            while (rowIterator.hasNext()) {
                List<String> Ll = new LinkedList<String>();
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                int cellCount = row.getPhysicalNumberOfCells();
//                int cellcount = 0;
                for (int i = 0; i < cellCount; i++) {
                    Cell cell = row.getCell(i);
                    //Check the cell type and format accordingly
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                Ll.add(i, Double.toString(cell.getNumericCellValue()));
                                System.out.print(cell.getNumericCellValue() + " ");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                Ll.add(i, cell.getStringCellValue());
                                System.out.print(cell.getStringCellValue() + " ");
                                break;
                        }
                    } else {
                        Ll.add(i, "");
                        System.out.print(" ");
                    }
                }
                System.out.println("");
                list.add(r, Ll);
                r++;
            }
            fis.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateSpecificCell(File file, int row_No, String status) {
        final int cell_No = 3;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(row_No);
            Cell cell2Update = row.getCell(cell_No);
            if (cell2Update == null) {
                cell2Update = row.createCell(cell_No);
            }
            cell2Update.setCellValue(status);

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("report.xlsx");
            workbook.write(outputStream);
            outputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
