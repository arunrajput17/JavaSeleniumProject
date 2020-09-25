package S14_JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C7_ScrollOnScreen {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	// Typecast driver to JavaScriptExecutor
		
		
		
		
		//--------------Scroll to bottom of screen------------
		// scroll("(horizontal, vertical)");
		
		js.executeScript("scroll(0,200)");
		
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
//		js.executeScript("window.scrollTo(0, '+y+')");
		
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
