package S23n25_WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S23_WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		// Counting number of rows
		int rowCount= driver.findElements(By.xpath("//*[@id='HTML1']/div/table/tbody/tr")).size();
		System.out.println(rowCount);
		
		// Counting number of columns
		int colCount= driver.findElements(By.xpath("//*[@id='HTML1']/div/table/tbody/tr[1]/th")).size();
		System.out.println(colCount);
		
		
		// Reading data from table
		for(int i=2; i<=rowCount; i++)
		{
			for(int j=1; j<=colCount; j++)
			{
				String value =driver.findElement(By.xpath("//*[@id='HTML1']/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(value+"  ");
				
			}
			System.out.println();
		}
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
