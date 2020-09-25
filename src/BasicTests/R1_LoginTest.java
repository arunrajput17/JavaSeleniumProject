package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class R1_LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		//Firefox driver
//		System.setProperty("webdriver.gecko.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\geckodriver.exe");
		
		// Chrome Driver
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		
		// IE driver
//		System.setProperty("webdriver.ie.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\IEDriverServer.exe");
		
		// Microsoft Edge
//		System.setProperty("webdriver.edge.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\MicrosoftWebDriver.exe");	
		
		
		
//		FirefoxDriver driver = new FirefoxDriver();		// Invoke the browser
		
		// 1) Open browser
		
		// Firefox
//		WebDriver driver = new FirefoxDriver();		// WebDriver is Interface and FireFoxDriver is class
		
		// Chrome
		WebDriver driver = new ChromeDriver();
		
		// IE 
//		WebDriver driver = new InternetExplorerDriver();
		
		//Microsoft Edge
//		WebDriver driver = new EdgeDriver();
		
		
		// 2) open URL in browser
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize(); 		//maximize the browser window
		
		// 3) Enter username
//		driver.findElement(By.name("userName")).sendKeys("mercury");		//OR
		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys("mercury");
		
		// 4) Enter password
		driver.findElement(By.name("password")).sendKeys("mercury");
		
		// 5) Click Submit button
		driver.findElement(By.name("submit")).click();
		
		// 6) Check the page title
		String expTitle ="Login: Mercury Tours";
		
		Thread.sleep(5000);
		String actTitle = driver.getTitle();			// Returns title of the page
		System.out.println(actTitle);
		
		
		//Validation
		if (expTitle.equals(actTitle))
		{
			System.out.println("Test is passed");
		}
		else
		{
			System.out.println("Test is failed");
		}
		
		// 7) Close browser
		driver.close();
		

	}

}
