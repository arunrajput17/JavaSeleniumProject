package S55_TestNG;
/*
 * Parameters :
 * We can pass parameters at Class level, Test Level and Suite level.
 */

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A8_TC1TestNGParameters {
	
	WebDriver driver;
	
	
	// Parameterization of browser and URL
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String browser, String app)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(app);
		
		System.out.println("Started Setup...");
	}
	
	
	@Test(priority=1)
	void logoTest()
	{
		// capture Logo
		WebElement eleLogo = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		
		//Check logo is present or not
		Assert.assertTrue(eleLogo.isDisplayed(), "Logo not displayed on the page" );
		System.out.println("This is logo test");
	}
	
	
	@Test(priority=2)
	void homePageTitle()
	{
		String txtPageTitle =driver.getTitle();
		Assert.assertEquals( txtPageTitle,"OrangeHRM", "Title is not matched");
		System.out.println("This is Title test");
	}
	
	
	@AfterClass
	void close() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
	}

}
