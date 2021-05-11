// 2.	Write a program in Java to Check if string is palindrome

package java_Assignments;

import java.util.Scanner;

public class A02_Srting_Plaindrome {

	public static void main(String[] args) {

		String  actual, rev = "";

		System.out.println("enter string 1");
		Scanner scanner = new Scanner(System.in);
		actual = scanner.nextLine();

		for (int i = 0; i < actual.length(); i++) {

			rev = actual.charAt(i) + rev;

		}

		if (actual.equalsIgnoreCase(rev))
			System.out.println(actual + " is a palindrome");
		else
			System.out.println(actual + " is not a palindrome");

		scanner.close();
	}

}
