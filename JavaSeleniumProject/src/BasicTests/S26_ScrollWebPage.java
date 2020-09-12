package BasicTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S26_ScrollWebPage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

		System.out.println("Start");
		
		// Java executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		// Scroll down the page by pixel
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		
		
		// Scroll down the page till element found
		WebElement flag= driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/table[1]/tbody/tr[86]/td[1]/img"));
		js.executeScript("arguments[0].scrollIntoView()", flag);
		Thread.sleep(3000);
		
		// Scroll to end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
