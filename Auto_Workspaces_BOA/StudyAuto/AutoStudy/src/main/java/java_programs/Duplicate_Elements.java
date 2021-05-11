package java_programs;
import java.util.HashMap;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Duplicate_Elements {

	public static void main(String[] args) {

	
		
		String chr [] ={"a","a", "b", "b", "c","d"};
		
		
		

		Map<String,Integer> mp =new HashMap<String,Integer>();
		
			
		for (String c:chr){
			
			Integer count = mp.get(c);
			
			if (count==null){
				
				mp.put(c, 1);
			}
			else{
				mp.put(c, ++count);
				
			}		
		}
		
	Set<Entry<String, Integer>> entryset = mp.entrySet();	
	
	for(Entry<String, Integer> entry : entryset){
		
		if(entry.getValue() > 1){
			
			System.out.println("duplicate value " + entry.getKey() +" and value is"+ entry.getValue());
		}
		 
	}
		
		}
	}


