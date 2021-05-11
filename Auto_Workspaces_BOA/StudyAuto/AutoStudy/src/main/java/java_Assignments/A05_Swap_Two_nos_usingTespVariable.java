package java_Assignments;

import java.util.Scanner;

public class A05_Swap_Two_nos_usingTespVariable {

	public static void main(String[] args) {

		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first no.");
		a = sc.nextInt();

		System.out.println("Enter second no.");
		b = sc.nextInt();

		
		a=a+b;
		b=a-b;
		a=a-b;
		
		
		System.out.println("value of a is: " + a);

		System.out.println("value of b is: " + b);

	}

}
