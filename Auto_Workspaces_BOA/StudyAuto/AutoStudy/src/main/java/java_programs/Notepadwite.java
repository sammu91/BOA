package java_programs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepadwite {

	public static void main(String[] args) throws IOException {

		String testfile = "C:/Users/sumitsh/Desktop//temp.txt";
		File fc = new File (testfile);
		fc.createNewFile();
		
		FileWriter fr = new FileWriter(testfile);
		BufferedWriter bw = new BufferedWriter(fr);
		
		bw.write("Given valid ID & PWD return valid.");
		bw.newLine();
		bw.write("Given invalid ID & PWD return invalid.");
		bw.close();
		
		FileReader FR = new FileReader(testfile);
		BufferedReader BR = new BufferedReader(FR);
		  String Content = "";
		  
		  //Loop to read all lines one by one from file and print It.
		  while((Content = BR.readLine())!= null){
		   System.out.println(Content);
		  }
		System.out.println("file created");
	}

}
