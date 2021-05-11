package java_Assignments;

import java.util.Scanner;

public class A04b_largest_number_without_array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a, b, c;

		System.out.println("Enter first no.");
		a = sc.nextInt();

		System.out.println("Enter second no.");
		b = sc.nextInt();
		
		System.out.println("Enter third no.");
		c = sc.nextInt();

		
		if(a>b && a>c) 
			
			System.out.println(a +" : is greater");
		else if(b>c)
			System.out.println(b +" : is greater");
		
		else
			System.out.println(c +" : is greater");
			
			
			
	}

}
