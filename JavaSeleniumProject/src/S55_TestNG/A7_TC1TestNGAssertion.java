package S55_TestNG;
/*
 * Assertions in TestNG:
 * 
 * Hard Assertions: They will stop the test and next line of code will not executed if condition fails
 * 	- Assert.assertTrue() & Assert.assertFalse()
 * 	- Assert.assertEquals()
 * 
 * 
 * Soft Assertions: Even though the condition fails it will not stop the test and execute the rest of the code
 * SoftAssert softAssert = new SoftAssert();
 *  - softAssert.assertTrue(condition)
 *  - softAssert.assertAll()
 *  
 *  Drawback of SoftAssert is that, the softAssert object is shared across all test methods and if one test method fails then
 *  it will fail the other test method also even though the other test method is passed.
 *  
 *  So, to overcome above problem we need to create different object for each Test method.
 */


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class A7_TC1TestNGAssertion {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Started Setup...");
	}
	
	@Test(priority=1)
	void logoTest()
	{
		// capture Logo
		WebElement eleLogo = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		
		//Check logo is present or not
		Assert.assertTrue(eleLogo.isDisplayed(), "Logo not displayed on the page" );
//		Assert.assertFalse(eleLogo.isDisplayed(), "Logo displayed on the page" ); // this will fail as condition return True and we are expectng false
		System.out.println("This is logo test");
	}
	
	
	@Test(priority=2)
	void homePageTitle()
	{
		String txtPageTitle =driver.getTitle();
		Assert.assertEquals( txtPageTitle,"OrangeHRM123", "Title is not matched");
		System.out.println("This is Title test");	// If above condition is failed then this line will not execute (Hard Assertion)
	}
	
	@Test(priority=3)
	void softAssertTest()
	{
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(true);	// passed
		softAssert.assertEquals("welcome", "Welcome"); 	//false - Failed
		softAssert.assertEquals("selenium", "selenium"); 	// true - Passed
		System.out.println("Successfully Passed");
		softAssert.assertAll();
	}
	
	
	@AfterClass
	void close() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
	}

}
