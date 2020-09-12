package S27to34_MouseKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S28_MouseRightClick {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		System.out.println("Start");
		
		
		// created object of actions class
		Actions act = new Actions(driver);		
		
		// 2) Mouse Right Click
		WebElement rightButton = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		
		act.contextClick(rightButton).build().perform();	// right click
		driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();	// click on copy
		System.out.println(driver.switchTo().alert().getText());	// get the text in alert
		driver.switchTo().alert().accept();		// this will close alert by clicking ok
		
		System.out.println("Mouse Right click completed");
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();

	}

}
