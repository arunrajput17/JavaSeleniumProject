package S60_GoogleSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		Thread.sleep(3000);
		System.out.println("Start");
		
		//Google search box
		driver.findElement(By.name("q")).sendKeys("java");
		
		Thread.sleep(10000);
		
		// Manually created dynamic xpath for the suggestion come when we enter text in search
		List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		
		System.out.println(list.size());
		
		
		//Reading each element
		for(int i=0; i<list.size(); i++)
		{
			String listitem = list.get(i).getText();
			System.out.println(listitem);
			
			if (listitem.contains("javascript tutorial"))
			{
				System.out.println("Item found");
				list.get(i).click();
				break;
			}
			else
			{
				System.out.println("Item not found");
			}
		}
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();

	}

}
