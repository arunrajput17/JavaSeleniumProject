package S23n25_WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S25_DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		// No. of rows
		int rowCount =driver.findElements(By.xpath("/html/body/table/tbody/tr/td[1]")).size();
		System.out.println("No. of rows: "+ rowCount);		
		
//		// No. of columns
//		int colCount = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td")).size();
//		System.out.println("No. of columns: "+ colCount);
//		
		
		//Loop will execute till the last row of table.
		for(int i=1; i<=rowCount; i++)
		{
			//To calculate no. of columns(cells) in that specific row.
			int colCount = driver.findElements(By.xpath("/html/body/table/tbody/tr["+i+"]/td")).size();
			System.out.println("No. of cell in row "+i+" are "+colCount);
			
			for(int j=1; j<=colCount; j++)
			{
				// To retrieve text from that specific cell
				String cellText = driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println("Cell value od row number "+i+" and column number "+j+" is "+cellText);
				
			}
			System.out.println("----------------------------------");
		}
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
