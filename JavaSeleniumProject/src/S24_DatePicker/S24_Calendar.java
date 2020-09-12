package S24_DatePicker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.Enter;

public class S24_Calendar {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		/*
		// This code will not work on the current URL as the URL used for this type of calendar
		// is not working now
		
		// calendar having year as dropdown in the window and arrows to move month
		driver.findElement(By.xpath("html/body/form/div[2]/div[19]/img")).click(); 	// click on calendar icon
		
		Select y = new Select(driver.findElement(By.xpath("html/body/div[1]/div/div/select")));
		y.selectByVisibleText("2017");
		
		// navigate to future month(Dec) current june i.e. 6 click
		for(int i=6;i<=1; i--)
		{
			// click on Right arrow icon for future month
			driver.findElement(By.xpath("html/body/div[1]/div/a[2]/span")).click();
			
			// get text of month
			String m =driver.findElement(By.xpath("html/body/div[1]/div/div/span")).getText();
			
			// Check month is expected or not
			if (m.equals("December"))
			{
				
				// Select date 10 in Dec
				driver.findElement(By.linkText("10")).click();
				break;
			}
			
		}
		
		// navigate to past month(Jan) current june i.e. 5 click
		for(int j=5;j<=1; j--)
		{
			// click on Left arrow icon for past month
			driver.findElement(By.xpath("html/body/div[1]/div/a[2]/span")).click();
			
			// get text of month
			String m =driver.findElement(By.xpath("html/body/div[1]/div/div/span")).getText();
			
			// Check month is expected or not
			if (m.equals("January"))
			{
				
				// Select date 10 in Jan
				driver.findElement(By.linkText("10")).click();
				break;
			}
			
		}
		*/
		
		//--------------- New Calendar having no selection for year------------------
		
		// click on the calendar text field to open calendar
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		
		for (int k=4; k>=1; k--)
		{
			// click on Right arrow icon for future month
			driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[2]/span")).click();
			
			// get text of month
			String monthText=driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/div/span[1]")).getText();
			
			if(monthText.equals("October"))
			{
				// Select date 10 in Oct
				driver.findElement(By.linkText("10")).click();
				break;
			}
			
		}
		
		
		

		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();


	}

}
