package S55_TestNG;
/*
 * Parallel Tests:
 * Advantages of parallel rests execution:
 * - Run Test methods parallel	(testngB10ParallelMethods.xml)
 * - Run test classes in parallel (testngB10ParallelMethods.xml)
 * - Run test suites in parallel
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class B10_TC1TestNGParallelTest {
	
	WebDriver driver;
	
	@Test
	void logoTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Started logotest...");
		
		// capture Logo
		WebElement eleLogo = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		
		//Check logo is present or not
		Assert.assertTrue(eleLogo.isDisplayed(), "Logo not displayed on the page" );
		System.out.println("This is logo test");
		Thread.sleep(5000);
	}
	
	
	@Test
	void homePageTitle() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.ie.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Started homePageTitle test...");
		
		String txtPageTitle =driver.getTitle();
		Assert.assertEquals( txtPageTitle,"OrangeHRM", "Title is not matched");
		System.out.println("This is Title test");
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	void tearDown()
	{
//		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();
	}

}
