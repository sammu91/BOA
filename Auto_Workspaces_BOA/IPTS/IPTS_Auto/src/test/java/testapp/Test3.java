package testapp;

public class Test3 {

	public static void main(String[] args) {

		String s1="sumit";
		String s2="sumit";
		String st = new String("sumit");
		String st1 = new String("sumit");
		
		
		
		boolean flag = s1.equalsIgnoreCase(st);
		System.out.println("flag "+flag);
		
		boolean flag2 = s1==st;
		System.out.println(flag2);
		
		boolean flag3 = s1==s2;
		System.out.println(flag3);
		
		boolean flag4 = st==st1;
		System.out.println(flag4);
		
		boolean flag5=st.equalsIgnoreCase(st1);
		System.out.println(flag5);
	}

}
