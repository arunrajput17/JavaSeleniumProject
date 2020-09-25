package BasicTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S16_Image {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/identify?ctx=recover");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		System.out.println("Print title 1: "+driver.getTitle());
		//click on the "Facebook" logo on the upper left portion	
		driver.findElement(By.cssSelector("a[title='Go to Facebook home']")).click();
		
		//verify that we are now back on Facebook's homepage	
//		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Facebook – log in or sign up"))
		{
			System.out.println("We are back at Facebook's homepage");
		}
		else
		{
			System.out.println("We are NOT in Facebook's homepage");
		}
		
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();


	}

}
