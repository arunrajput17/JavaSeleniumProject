package S62_PageObjectModelType2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationTest {
	
	@Test
	public void verifyFlightReg() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		RegistrationPage RGPage = new RegistrationPage(driver);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
		
		
		RGPage.clickRegLink();
		RGPage.setFirstName("John");
		RGPage.setlastName("Seana");
		RGPage.setPhone("1111111110");
		RGPage.setEmail("john@xyz.com");
		RGPage.setAddress("add1 fields");
		RGPage.setCity("London");
		RGPage.setState("UK");
		RGPage.setPostalCode("11111");
		
		RGPage.setCountry("UNITED KINGDOM");
		
		RGPage.setUserName("johnseana");
		RGPage.setPassword("123456");
		RGPage.setConfirmedPassword("123456");
		
		RGPage.clickRegBtn();
		
		
		//Validation
		
		if (driver.getPageSource().contains("Thank you for registering"))
		{
			System.out.println("Your registration is successfully completed - TEST PASSED ");
		}
		else
		{
			System.out.println("Your registration is Failed - TEST FAILED");
		}
		
		
		System.out.println("Test end");
		Thread.sleep(5000);
		
		driver.close();
		
		
		
		
	}

}
