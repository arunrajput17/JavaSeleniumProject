package S55_TestNG;

import org.testng.annotations.Test;

/*
 * Prioritizing Tests :
 * -Without priority it will execute in order 4,1,3 & 2. i.e. Alphabetical order
 * 
 * Disabling Tests :
 */

public class A4_TC1TestNGPrioritizingDisabling {
	
	
	@Test(priority=0)
	void testOne()
	{
		System.out.println("This is Test 1.......");
	}
	
	
	@Test(priority=1)
	void testTwo()
	{
		System.out.println("This is Test 2.......");
	}
	
	
	@Test(priority=2)
	void testThree()
	{
		System.out.println("This is Test 3.......");
	}
	
	
	@Test(priority=3, enabled=false)	// Disabling this method
	void testFour()
	{
		System.out.println("This is Test 4.......");
	}

}
