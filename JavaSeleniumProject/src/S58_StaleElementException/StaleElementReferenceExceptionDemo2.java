package S58_StaleElementException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExceptionDemo2 {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
		
		Thread.sleep(3000);
		System.out.println("Start");
		
		
		WebElement txtUsername = driver.findElement(By.name("email"));
		txtUsername.sendKeys("username");
		
		
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("password");
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();;
		
		Thread.sleep(5000);
		
		
		// Handeled using try catch
		try 
		{
			System.out.println("user");
			txtUsername.sendKeys("username");
		} 
		catch (StaleElementReferenceException e) 
		{
			txtUsername = driver.findElement(By.name("email"));
			txtUsername.sendKeys("username");
		}
		
		
		try 
		{
			System.out.println("pwd");
			txtPassword.sendKeys("password");
		} 
		catch (StaleElementReferenceException e) 
		{
			txtPassword = driver.findElement(By.name("password"));
			txtPassword.sendKeys("password");
		}
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();
		
	}
	
}
