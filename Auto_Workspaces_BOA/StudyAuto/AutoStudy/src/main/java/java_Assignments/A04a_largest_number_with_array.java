package java_Assignments;

public class A04a_largest_number_with_array {

	public static void main(String[] args) {
		

		int a []= {1,2,3,4,6,8,5};
		
		
		int max=0;
		
		for (int i = 0; i < a.length; i++) 
		{
			if (max < a[i]) {
				
				max=a[i];
			}
			
		}
		
		
		System.out.println(max);
		
	}

}
