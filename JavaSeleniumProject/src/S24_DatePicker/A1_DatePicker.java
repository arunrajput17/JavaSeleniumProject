package S24_DatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_DatePicker {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/");
		
		System.out.println("Start");
		
		
		String month= "November";
		String year = "2021";
		String date = "10";
		
		//Click on check in 
		driver.findElement(By.xpath("//input[@id='checkin']")).click();
		Thread.sleep(2000);
		System.out.println("calendar text clicked");
		
		while(true)
		{
			String textMonthYear = driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/nav/div[2]")).getText();
			System.out.println(textMonthYear);
			String arrMonthYear[] =textMonthYear.split(",");
			System.out.println("After split month is:"+arrMonthYear[0]+ " and year is :"+arrMonthYear[1].trim());
			
			
			if((arrMonthYear[0].equals(month)) && ((arrMonthYear[1].trim()).equals(year))  )
			{
				break;
			}
			else
			{
				//click on next
				driver.findElement(By.xpath("//div[1]//nav[1]//div[3]//*[local-name()='svg']")).click();
//				driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/nav/div[3]/svg")).click();
			}
		}
		
		//Click on date
		driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div/div[2]/div[contains(text(),"+date+")]")).click();
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
	}

}
