package S48n49_EncodingDecoding;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S49_EncodingDecodingTestCase {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		System.out.println("Start");
		Thread.sleep(2000);
		
		
		driver.findElement(By.name("userName")).sendKeys("admin");
		
		// Passing encoded value in password
		driver.findElement(By.name("password")).sendKeys(decodeString("YWRtaW4="));
		
		driver.findElement(By.name("submit")).click();
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
		
	}
	
	static String decodeString(String password)
	{
		byte[] decodedString = Base64.decodeBase64(password);
		return(new String(decodedString));
	}
	

}
