package testApp;

import java.util.Random;

public class extra {

	public static void main(String[] args) {

		
		Random rd= new Random();
		//int num = rd.nextInt(34);
		
		
		
		for (int i = 0; i < 100; i++) {
			String id = String.format("%04d", rd.nextInt(10000));
			
			System.out.println(id);
		}
	}

}
