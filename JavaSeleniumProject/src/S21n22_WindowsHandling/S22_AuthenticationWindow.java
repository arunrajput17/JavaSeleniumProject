package S21n22_WindowsHandling;
//Authentication Window

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S22_AuthenticationWindow {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		System.out.println("Start");
		
		// Syntax for working with authentication pop ups
		// http://username:password@test.com
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String text = driver.findElement(By.cssSelector("p")).getText();		
		System.out.println(text);
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close(); 	//it will close the focused window

	}

}
