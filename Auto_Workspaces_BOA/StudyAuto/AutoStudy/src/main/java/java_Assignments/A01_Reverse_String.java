package java_Assignments;

import java.util.Scanner;

public class A01_Reverse_String {

	public static void main(String[] args) {
		
		
		

// 1. initialize with first chracter
		String rev = "";
		String actual = null;

		System.out.println("enter string 1");
		Scanner scanner = new Scanner(System.in);
		actual = scanner.nextLine();

		for (int i = 0; i < actual.length(); i++) {

			rev = actual.charAt(i) + rev;

		}

		System.out.println("reverse string 1 is:  " + rev);

		
		
// 2. Or initialize with last
		System.out.println("enter string 2");

		String rev2 = "";
		actual = scanner.nextLine();

		for (int i = actual.length() - 1; i >= 0; i--) {

			rev2 = rev2 + actual.charAt(i);

		}

		System.out.println("reverse string 2 is:  " + rev2);

		scanner.close();

		
//3. Using reverse method
		
		StringBuilder sb = new StringBuilder(actual);
		System.out.println("from reverse method : "+sb.reverse());
		
	}

}
