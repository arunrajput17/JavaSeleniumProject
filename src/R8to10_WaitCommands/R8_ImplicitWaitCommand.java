package R8to10_WaitCommands;

//Implicit wait : is applicable for all the elements on the page. 
//This need to be specified one time at the beginning of the code.

// Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time before 
// throwing an exception. Once this time is set, WebDriver will wait for the element before the
// exception occurs.

// Once the command is in place, Implicit Wait stays in place for the entire duration for which
// the browser is open. Its default setting is 0, and the specific wait time needs to be set by
// the following protocol.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class R8_ImplicitWaitCommand {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();	// To maximize browser window
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		// Implicit wait : it waits for maximum 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
