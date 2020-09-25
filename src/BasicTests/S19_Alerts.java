package BasicTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S19_Alerts {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		System.out.println("Start");
		
		// Click button 'click me'
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		Thread.sleep(2000);
		
		// closes alert window using OK button
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		// // To capture the alert message.
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		
		// closes alert window using Cancel button
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
//		// To send some data to alert box. 
		driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("1hahaaahhaahahah1");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		
					

		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
	}

}
