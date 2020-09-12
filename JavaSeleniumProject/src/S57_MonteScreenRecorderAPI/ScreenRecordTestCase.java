package S57_MonteScreenRecorderAPI;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenRecordTestCase {
	
	WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.nopcommerce.com/");
	}
	
	
	@Test
	void verifyLinks() throws Exception
	{
		
		// Starting recording from here
		ScreenRecorderUtil.startRecord("verifyLinks");
		
		
		//Computers
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
		System.out.println(driver.getTitle());
		
		// Electronics
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
		System.out.println(driver.getTitle());
		
		// Apparel
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a")).click();
		System.out.println(driver.getTitle());
		
		// Digital Downloads
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a")).click();
		System.out.println(driver.getTitle());
		
		// Books
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a")).click();
		System.out.println(driver.getTitle());
		
		// Jewelry
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a")).click();
		System.out.println(driver.getTitle());
		
		// Gift Cards
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a")).click();
		System.out.println(driver.getTitle());
		
		
		
		// Stop Recording
		ScreenRecorderUtil.stopRecord();
		
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}

}
