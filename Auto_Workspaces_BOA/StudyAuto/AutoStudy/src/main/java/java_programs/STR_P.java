package java_programs;

public class STR_P {

	public static void main(String[] args) {

		String st="ab bab bd d jgkjkfbd f,, fd";
		
		int blank=0;
		int word=0;
		int count = st.length();
		System.out.println(count);
		for (int i = 0; i<count;i++){
			
			if (st.charAt(i)==' '){
				 blank++;
			}else{
				word++;
			}
				
		}
		System.out.println(blank+"blankspace");
		System.out.println(word+"words in ");
	}

}
