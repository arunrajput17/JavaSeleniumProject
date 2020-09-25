package S24_DatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_DatePicker {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.co.in/");
		
		System.out.println("Start");
		
		
		String month = "November 2021";
		String date = "20";
		
		//Click on the Check-in field to open calendar
		driver.findElement(By.xpath("//button[@id='d1-btn']")).click();
		Thread.sleep(2000);
		System.out.println("calendar text clicked");
		
		
		while(true)
		{
			String textMonthYear = driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/h2")).getText();
			System.out.println(textMonthYear);
			
			if(textMonthYear.equals(month))
			{
				break;
			}
			else
			{
				//click on next
				driver.findElement(By.xpath("//*[@id='wizard-hotel-pwa-v2-1']/div[1]/div[2]/div/div/div/div[1]/div/div[2]/div/div[1]/div[1]/button[2]")).click();
				
			}
		}
		
//		WebElement elem=driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[6]/button"));
//		System.out.println(elem.getAttribute("data-day"));
		
		
		//Click on date
		List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button"));
		
		for(WebElement ele:allDates)
		{
			if((ele.getAttribute("data-day")).equals(date))
			{
				System.out.println(ele.getAttribute("data-day"));
				ele.click();
				break;
			}
			
		}
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
	}

}
