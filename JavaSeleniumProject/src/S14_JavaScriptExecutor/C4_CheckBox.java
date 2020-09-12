package S14_JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C4_CheckBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	// Typecast driver to JavaScriptExecutor
		
		
		
		
		// -------------check box---------------------------------------
		WebElement eleSun = driver.findElement(By.cssSelector("input#RESULT_CheckBox-8_0"));
		WebElement eleSat = driver.findElement(By.cssSelector("input.multiple_choice[value=CheckBox-6]"));
		
		//1st method
		js.executeScript("arguments[1].click();arguments[0].click();", eleSun,eleSat);	
		
		//2nd method
//		js.executeScript("arguments[0].checked=true; arguments[1].checked=true;", eleSun,eleSat);	
		
		//3rd method
//		js.executeScript("document.getElementById('RESULT_CheckBox-8_0').click()");	
		
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
