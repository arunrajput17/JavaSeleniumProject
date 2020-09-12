package S55_TestNG;
/*
 * Introduction of TestNG
 * - TestNG is testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more
 *	powerful and easier to use.
 * - TsetNG is designed to cover all categories of tests : unit, functional, ene-to-end, integration etc.
 * 
 * Advantages Of TestNG
 * - Manages Test suites and test cases
 * - Helps in Prioritizing of tests
 * - Helps in Grouping of tests
 * - Parallel execution
 * - Reporting
 * 
 */

import org.testng.annotations.Test;

public class A1_TestNGIntro {
	
	@Test(priority=1)
	public void setup()
	{
		System.out.println("This is setup test - Opening browser");
	}
	
	
	@Test(priority=2)
	void login()
	{
		System.out.println("This is login test");
	}
	
	
	@Test(priority=3)
	void teardown()
	{
		System.out.println("Closing browser");
	}
	

}
