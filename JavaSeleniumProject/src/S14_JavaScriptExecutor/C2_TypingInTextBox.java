package S14_JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_TypingInTextBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		

		JavascriptExecutor js = (JavascriptExecutor)driver;	// Typecast driver to JavaScriptExecutor
		
		
		
		
		// ---------------Typing in Textbox-----------
		// It will handle all textbox which we are not able to enter data using SEndKeys due to some properties
		// DisAdv - it will event insert data in disabled text box
		
		
		//1st method
		js.executeScript("document.getElementById('RESULT_TextField-1').value='John'");	
		
		
		// 2nd Method
		WebElement eleLast = driver.findElement(By.id("RESULT_TextField-2"));	
		js.executeScript("arguments[0].value='Salvator'", eleLast);	
		
		
		// 3rd method to dynamically pass value also
		WebElement elePhone = driver.findElement(By.id("RESULT_TextField-3"));	
		js.executeScript("arguments[0].value=arguments[1]", elePhone,"111111112");
		
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
