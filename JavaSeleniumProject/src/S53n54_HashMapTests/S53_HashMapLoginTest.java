package S53n54_HashMapTests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S53_HashMapLoginTest {
	
	
	static HashMap<String, String> logindata()
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("x", "mercury@mercury");
		hm.put("y", "mercury1@mercury1");
		hm.put("z", "mercury2@mercury2");
		
		return hm;
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
		System.out.println("Start");
		Thread.sleep(2000);
		
		// Login as x
		String credentials =logindata().get("x");
		String arr[]=credentials.split("@");
		
		
		
		driver.findElement(By.name("userName")).sendKeys(arr[0]);
		driver.findElement(By.name("password")).sendKeys(arr[1]);
		driver.findElement(By.name("submit")).click();
		
		if (driver.getTitle().equals("Login: Mercury Tours"))
		{
			System.out.println("Test case is passed");
		}
		else
		{
			System.out.println("Test case is Failed");
		}
		driver.findElement(By.linkText("Home")).click();
		
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
