package java_Assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A07_Read_frm_txtfile {

	public static void main(String[] args) throws FileNotFoundException {

		File fil = new File("C:/Users/sumitsh/Desktop/New Text Document.txt");
		Scanner sc = new Scanner(fil);
		
		
//		while (sc.hasNext()) {
//			System.out.println(sc.next());
//			
//		}

	sc.useDelimiter("\\Z");
	System.out.println(sc.next());
	
	}

}
