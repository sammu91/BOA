package java_programs;

public class Factorial_recursion {

	
	public static int Fact(int num){
		
		if (num==0){
			return 1;
		}
		else{
			
			return (num*Fact(num-1));	
		}	
	}
	
	
	
	
	
	public static void main(String[] args) {

		int fact1=Fact(5);
		System.out.println(fact1);
	
			
			
		
	}

}
