package S21n22_WindowsHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S21_BrowserwindowsHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		System.out.println("Start");
		
		// Click on click button
		driver.findElement(By.xpath("//a[@target='_blank']")).click();
		
		// it will written the parent window handle
		System.out.println(driver.getWindowHandle());
		
		// to get all the widows multiple handles
		Set<String> winHandles = driver.getWindowHandles();
		
		for(String i : winHandles)
		{
			driver.switchTo().window(i);
			System.out.println(driver.getTitle());
			System.out.println(i);
			
			if(driver.getTitle().equalsIgnoreCase("Frames & windows")==true)
			{
				driver.close();	// close only parent browser
			}
		}

//		// Using Iterator and While loop
		
//		Iterator<String> i1 = winHandles.iterator();
//		
//		while (i1.hasNext())
//		{
//			String childwindow = i1.next();
//			
//			driver.switchTo().window(childwindow);
//			System.out.println(driver.getTitle());
//			if(driver.getTitle().equalsIgnoreCase("Frames & windows"))
//			{
//				driver.close();	// close only parent browser
//			}
//		}
		
		
		Thread.sleep(5000);
		System.out.println("End");
//		driver.quit();

		
	}

}
