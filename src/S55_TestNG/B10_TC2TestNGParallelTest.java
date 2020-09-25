package S55_TestNG;
/*
 * Parallel Tests:
 * Advantages of parallel rests execution:
 * - Run Test methods parallel	(testngB10ParallelMethods.xml)
 * - Run test classes in parallel
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

public class B10_TC2TestNGParallelTest {
	
	WebDriver driver;
	
	@Test
	void loginTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Started login test...");
		
		// Enter login details
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		//Check title is as expected
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Page title does not match" );
		System.out.println("This is login test");
		Thread.sleep(5000);
	}
	
	
	
	
	@AfterMethod
	void tearDown()
	{
//		Thread.sleep(5000);
		System.out.println("End of login test");
		driver.quit();
	}

}
