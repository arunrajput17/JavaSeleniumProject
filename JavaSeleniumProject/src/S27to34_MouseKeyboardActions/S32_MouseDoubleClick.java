package S27to34_MouseKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S32_MouseDoubleClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		System.out.println("Start");
		
		
		// created object of actions class
		Actions act = new Actions(driver);	
		
		
		// 6) Double click
		Thread.sleep(3000);
		
		WebElement dblClkButton = driver.findElement(By.xpath("//*[@id='HTML10']/div[1]/button"));
		act.doubleClick(dblClkButton).build().perform();
		System.out.println("Mouse Doble click completed");
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();

	}

}
