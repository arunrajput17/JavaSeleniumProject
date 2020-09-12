package S27to34_MouseKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S30_MouseSlider {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/slider/");
		
		System.out.println("Start");
		
		
		// created object of actions class
		Actions act = new Actions(driver);	
		
		
		// 4) Slider
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);		// only one frame index is Zero switching to it
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));	// identifying slider 
		
		act.moveToElement(slider).dragAndDropBy(slider, 300, 0).build().perform();
		
		System.out.println("Slider navigation is completed");
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();


	}

}
