package S20_FramesAndiFrames;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S20_FramesAndiFrames {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		
		System.out.println("Start");
		
		// switching to First frame click on org.openqa.selenium
		driver.switchTo().frame("packageListFrame");	// switching to first frame
//		//-------------------OR---------------
//		// If we dont have frame name then we need to pass the whole frame work xpath. Syntax is
//		driver.switchTo().frame(driver.findElement(By.xpath("xpathExpression"))):
				
		
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		Thread.sleep(3000);
		
		
		// Go back to main frame before switching to another frame this is mandatory we can not 
		// directly switch  between frames
		driver.switchTo().defaultContent();
		
		
		// switch to second frame
		driver.switchTo().frame("packageFrame");	// switch to second frame
		driver.findElement(By.linkText("WebDriver")).click();
		Thread.sleep(3000);
		
		// Switch to default frame
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		//  Switch to third frame
		driver.switchTo().frame("classFrame");	//  switch to third frame
		driver.findElement(By.xpath("/html/body/div[1]/ul/li[5]")).click();
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
