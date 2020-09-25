package S58_StaleElementException;

/*
 * Stale Element :
 * - Stale means old, decayed, no longer fresh.
 * - Stale element means an old element or no longer available element
 * - Assume there is an element that is found on a web page referenced as a WebElement in WebDriver. If the DOM changes then the
 * 		WebElement goes stale. If we try to interact with an element which is staled then StaleElementReferenceException is thrown.
 * - When this happens you will need to refresh your reference, or find the element again.
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExceptionDemo1 {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.pavantestingtools.com/");
		
		Thread.sleep(3000);
		System.out.println("Start");
		
		
		WebElement linkTraining = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]/a"));
		linkTraining.click();
		
		
		WebElement linkSelfPaced = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]/ul/li[2]/a"));
		linkSelfPaced.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(5000);
		
//		linkTraining.click();	// this will give staleElement exception
//		linkSelfPaced.click();
		
		
		// Handling StaleElementException
		
		try
		{
			linkTraining.click();
		}
		catch(StaleElementReferenceException e)
		{
			linkTraining = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]/a"));
			linkTraining.click();
		}
		
		try 
		{
			linkSelfPaced.click();
		} 
		catch (StaleElementReferenceException e) 
		{
			linkSelfPaced = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[2]/ul/li[2]/a"));
			linkSelfPaced.click();
		}
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();
		
	}
	
}
