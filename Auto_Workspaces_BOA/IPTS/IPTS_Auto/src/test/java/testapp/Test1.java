package testapp;

import java.util.Random;

import com.ipts.o1generic.ConfigLib;
import com.ipts.o1generic.seleniumlib;

public class Test1 {

	public static void main(String[] args) {

		System.out.println(ConfigLib.dirPath + "\\testdata\\Client_File_Upload.xlsx");
		for (int i = 0; i < 5; i++) {
		Random rd = new Random();
		
			String docID = String.format("%04d", rd.nextInt(10000));

			System.out.println("Doc id is " + docID);

		}


	}

}
