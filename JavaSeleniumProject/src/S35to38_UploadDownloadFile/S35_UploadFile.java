package S35to38_UploadDownloadFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S35_UploadFile {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		System.out.println("Start");
		
		driver.switchTo().frame(0);		// Switching to frame
		
		// Uploading file
		driver.findElement(By.id("RESULT_FileUpload-10")).sendKeys("D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\sample.PNG");
		
			
		
		
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();

	}

}
