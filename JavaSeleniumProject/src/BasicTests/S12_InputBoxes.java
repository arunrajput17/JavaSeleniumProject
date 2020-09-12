package BasicTests;

import java.util.List;

// Input Box:

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S12_InputBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		// 1. How to find how many input boxes present in web page
		List<WebElement> inputBoxes = driver.findElements(By.className("text_field"));
		System.out.println("Number of Textboxes are :"+inputBoxes.size());
		
		// 2. Printing the name of textboxes available on the list. 
		for (WebElement i :inputBoxes)
		{
			System.out.println("Textbox name :"+i.getAttribute("name"));
		}
		
		// 3. How to get the status of text box
		Boolean status = driver.findElement(By.id("RESULT_TextField-1")).isDisplayed();
		System.out.println(status);
		
		boolean status2 = driver.findElement(By.id("RESULT_TextField-1")).isEnabled();
		System.out.println(status2);
		
		// 4. How to provide value into text box
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("John");
		
		WebElement LastName = driver.findElement(By.id("RESULT_TextField-2"));
		LastName.sendKeys("Ciena");
		
		
		// Deleting Values in Input Boxes
		driver.findElement(By.id("RESULT_TextField-1")).clear();
		
		
		Thread.sleep(5000);
		System.out.println("End");
		
		driver.close();

	}

}
