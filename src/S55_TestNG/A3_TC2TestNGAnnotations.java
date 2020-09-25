package S55_TestNG;

import org.testng.annotations.*;

public class A3_TC2TestNGAnnotations {
	
	
	@BeforeClass
	void beforeClass()
	{
		System.out.println("This will execute one time before the Class....");
	}
	
	
	@AfterClass
	void afterClass()
	{
		System.out.println("This will execute one time after the Class....");
		System.out.println("");
	}
	
	
	@BeforeMethod
	void beforeMethod()
	{
		System.out.println("This will execute before every Method....");
	}
	
	
	@AfterMethod
	void afterMethod()
	{
		System.out.println("This will execute after every Method....");
		
	}
	
	
	@Test
	void test3()
	{
		System.out.println("This is test 3..............");
	}
	
	
	@Test
	void test4()
	{
		System.out.println("This is test 4 ...............");
	}
	
	
	@BeforeSuite
	void beforeSuite()
	{
		System.out.println("This will execute before Test Suite....");
	}
	
	
	@AfterSuite
	void afterSuite()
	{
		System.out.println("This will execute after Test Suite....");
	}
	

}
