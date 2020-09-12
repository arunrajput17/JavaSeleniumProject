package S63_Log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Log4jPropertiesFileExample {

	public static void main(String[] args) {
		
		
		// Here we need to create logger instance so we need to pass Class name
		Logger logger = Logger.getLogger("Log4jExample");
		PropertyConfigurator.configure("Log4j.properties");		// Log4j.properties file configuration
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		logger.info("Browser opened");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		
		logger.info("Clicked on Register");
		driver.findElement(By.linkText("REGISTER")).click();
		
		logger.info("Entering contact information");
		driver.findElement(By.name("firstName")).sendKeys("John");
		
		driver.findElement(By.name("lastName")).sendKeys("Seana");
		driver.findElement(By.name("phone")).sendKeys("1111111110");
		driver.findElement(By.name("userName")).sendKeys("john@xyz.com");

		
		logger.info("Entering Mailing Information");
		driver.findElement(By.name("address1")).sendKeys("add1 fields");
		driver.findElement(By.name("city")).sendKeys("London");
		driver.findElement(By.name("state")).sendKeys("UK");
		driver.findElement(By.name("postalCode")).sendKeys("11111");
		
		
		logger.info("Selecting Country");
		WebElement con =driver.findElement(By.name("country"));
		Select drop = new Select(con);
		drop.selectByVisibleText("UNITED KINGDOM");

		
		logger.info("Entering User Information");
		driver.findElement(By.name("email")).sendKeys("johnseana");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456");

		
		logger.info("Clicked on Submit button" );
		driver.findElement(By.name("submit")).click();

		
		//Validation
		logger.info("Validation started");
		if (driver.getPageSource().contains("Thank you for registering"))
		{
			System.out.println("Your registration is successfully completed - TEST PASSED ");
			logger.info("Validation DONE");
		}
		else
		{
			System.out.println("Your registration is Failed - TEST FAILED");
			logger.info("Validation DONE");
		}
		logger.info("Exit Test");
		
		driver.quit();
		logger.info("Browser quit");

	}

}
