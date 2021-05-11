package testNGTest;

import org.testng.annotations.Test;

public class GroupTest {
	
	@Test(groups= {"smoke"})
	public void tc1() {
		System.out.println("tc1"+"smoke");
	}
	
	@Test(groups= {"smoke"})
	public void tc2() {
		System.out.println("tc2"+"smoke");
	}

	@Test(groups= {"smoke"})
	public void tc3() {
		System.out.println("tc3"+"smoke");
	}
	
	@Test(groups= {"reg"})
	public void tc4() {
		System.out.println("tc5"+"reg");
	}

	@Test(groups= {"reg"})
	public void tc5() {
		System.out.println("tc5"+"reg");
	}
	
	@Test(groups= {"reg"})
	public void tc6() {
		System.out.println("tc6"+"reg");
	}

	@Test(groups= {"smoke","reg"})
	public void tc7() {
		System.out.println("tc7"+"reg and smoke");
	}
	
	@Test(groups= {"smoke","reg"})
	public void tc8() {
		System.out.println("tc8"+"reg and smoke");
	}
	
}
