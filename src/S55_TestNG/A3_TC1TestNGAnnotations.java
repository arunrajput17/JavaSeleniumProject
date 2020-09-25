package S55_TestNG;


import org.testng.annotations.*;

/*
 * Annotations in TestNG :
 * - We can control the sequence and priority of the methods which allows to execute java code before and after a certain point.
 * - Annotations are placed over the method with the symbol @.
 * 
 * @BeforeSuite
 * 		@BeforeTest
 * 			@BeforeClass
 * 				@BeforeMethod
 * 								@Test
 * 				@AfterMethod
 * 			@AfterClass
 * 		@AfterTest
 * @AfterSuite	
 * 
 */




public class A3_TC1TestNGAnnotations {
	
	
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
	void test1()
	{
		System.out.println("This is test 1..............");
	}
	
	
	@Test
	void test2()
	{
		System.out.println("This is test 2 ...............");
	}
	
	
	@BeforeTest
	void beforeTest()
	{
		System.out.println("This will execute before Test....");
	}
	
	
	@AfterTest
	void afterTest()
	{
		System.out.println("This will execute after Test....");
	}
	

}
