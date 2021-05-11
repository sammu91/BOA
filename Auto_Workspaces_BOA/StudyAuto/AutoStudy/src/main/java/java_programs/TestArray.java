package java_programs;

import java.util.HashMap;

public class TestArray {

	public static void main(String[] args) {

		String str = "aabbccd";

		HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
		
		for (int i = 0; i < str.length(); i++) {
			
			if(map.containsKey(str.charAt(i))){
				
				int count=map.get(str.charAt(i));
				map.put(str.charAt(i), ++count);
				
			}
			else{
				map.put(str.charAt(i), 1);
			}
		}
	
		System.out.println(map);
	
	}
}
