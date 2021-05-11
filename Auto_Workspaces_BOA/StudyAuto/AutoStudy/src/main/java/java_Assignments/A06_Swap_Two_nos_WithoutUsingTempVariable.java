package java_Assignments;

import java.util.Scanner;

public class A06_Swap_Two_nos_WithoutUsingTempVariable {

	public static void main(String[] args) {

		int a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first no.");
		a = sc.nextInt();

		System.out.println("Enter second no.");
		b = sc.nextInt();

		c = a;
		a = b;
		b = c;

		System.out.println("value of a is: " + a);

		System.out.println("value of b is: " + b);

	}

}
