package CSVwriter;


// Commented this becuase due to csv writer jenkins is not working properly so that is why it is commented
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVTest {

	public static void main(String[] args) throws IOException {

		
//	
//// Write single line at a time	
//		File fil = new File("C:\\Users\\sumitsh\\Desktop\\test.csv");
//		
//		FileWriter fw= new FileWriter(fil);
//		
//		CSVWriter writer1 = new CSVWriter(fw);
//		
//		String [] data1= {"abd","def","dat2"};
//		
//		writer1.writeNext(data1);
//		
//		System.out.println("single line data written");
//		writer1.close();
//	
//		
//		
///* Write all Data at once- For witting data at once call writeAll() 
//method of CSVWriter class and pass A List of String[] as the 
//parameter with each String[] representing a line of the file.*/
//		
//		
//		
//		CSVWriter writer2 = new CSVWriter(new FileWriter(new File("C:/Users/sumitsh/Desktop/writeall.csv")));
//		String [] dat= {"abd","def","dat2"};
//		
//		List<String[]> data2= new ArrayList<String[]>();
//		data2.add(dat);  // passing variable 
//		data2.add(new String[] {"1","3","4"});
//		
//		writer2.writeAll(data2);
//		System.out.println("all dat in one written");
//		writer2.close();
//		
//		
//		
///*By default, the separator for CSV will be a comma(, ). If you want to make another 
// * character as a separator so it can be passed as an argument to CSVWriter class.
// *Syntax :
//CSVWriter(Writer writer, char separator, char quotechar,char escapechar, String lineEnd)
//Description : Constructs CSVWriter with supplied separator,quote char, escape char and line ending.*/		
//		
//		
//		// first create file object for file placed at location 
//	    // specified by filepath 
//	    File file = new File("C:/Users/sumitsh/Desktop/seprator.csv"); 
//	  
//	        // create FileWriter object with file as parameter 
//	        FileWriter outputfile = new FileWriter(file); 
//	  
//	        // create CSVWriter with '|' as separator 
//	        CSVWriter writer3 = new CSVWriter(outputfile, '|', 
//	                                         CSVWriter.NO_QUOTE_CHARACTER, 
//	                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
//	                                         CSVWriter.DEFAULT_LINE_END); 
//	  
//	        // create a List which contains String array 
//	        List<String[]> Data3 = new ArrayList<String[]>(); 
//	        Data3.add(new String[] { "Name", "Class", "Marks" }); 
//	        Data3.add(new String[] { "Aman", "10", "620" }); 
//	        Data3.add(new String[] { "Suraj", "10", "630" }); 
//	       
//	        writer3.writeAll(Data3); 
//	  
//	        // closing writer connection 
//	        writer3.close(); 
//	    	System.out.println("seprator data written");
	}

}
