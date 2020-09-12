package S14_JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C9_HighlightElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	// Typecast driver to JavaScriptExecutor
		
		
		
		
		//------------Highlight element method--------------
		

		WebElement eleCountry = driver.findElement(By.xpath("//input[@id='RESULT_TextField-4']"));
		
		//Highlighting field
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", eleCountry);
		Thread.sleep(5000);
		
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		//Un-highlight filed
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid white;')", eleCountry);
		Thread.sleep(3000);
		
		
	
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
