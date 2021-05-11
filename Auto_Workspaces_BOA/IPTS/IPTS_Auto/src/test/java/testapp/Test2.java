package testapp;

import com.ipts.o1generic.ConfigLib;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ConfigLib.getValue("test"));
		ConfigLib.set_update_Value("test", "checking");
		System.out.println("after set  "+ConfigLib.getValue("test"));
	}

}
