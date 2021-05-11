package java_programs;
import java.util.Arrays;
import java.util.Iterator;

public class Largestnumberarray {

	public static void main(String[] args) {

		
		int nos[]={23,56,-90,989,786,7865879,-209};
		
		int largestno=nos[0];
		int smallestno=nos[0];
		
	   int count=nos.length;
	   
	   
	
	   
	
     for(int i=0;i<count;i++){
		   
		   if (largestno<nos[i]){
			   
			   largestno=nos[i];
		   }
		   else if(smallestno>nos[i])
		   {
			   smallestno=nos[i];
		   }
	   }
	   
	   System.out.println(Arrays.toString(nos));
	   System.out.println("smallno"+smallestno);
	   System.out.println("largestno"+largestno);	
	}

}
