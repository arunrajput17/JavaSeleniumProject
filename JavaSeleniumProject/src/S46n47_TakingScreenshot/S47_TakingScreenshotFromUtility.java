package S46n47_TakingScreenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import library.Utility;

public class S47_TakingScreenshotFromUtility {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		System.out.println("Start");
		
		Utility.captureScreenshot(driver, "LoginScreen");
		
		
		driver.findElement(By.id("email")).sendKeys("Screenshot");
		Utility.captureScreenshot(driver, "TypeUname");
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();


	}

}
