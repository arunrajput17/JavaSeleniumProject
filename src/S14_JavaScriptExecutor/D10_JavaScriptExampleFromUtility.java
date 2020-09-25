package S14_JavaScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import library.JavaScriptUtil;

public class D10_JavaScriptExampleFromUtility {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;	// Typecast driver to JavaScriptExecutor
		
		// Flashing an element
		WebElement eleFirstName = driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']"));
		JavaScriptUtil.flash(eleFirstName, driver);
		Thread.sleep(2000);
		
//		driver.navigate().to("https://www.twoplugs.com/");
//		Thread.sleep(5000);
//		WebElement eleJoinNow = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a/span"));
//		JavaScriptUtil.flash(eleJoinNow, driver);
		
		
		
		// Drawing a border around the element
		JavaScriptUtil.drawBorder(eleFirstName, driver);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./TestFiles/higlight.png");
		FileUtils.copyFile(source, target);
	
		Thread.sleep(2000);
		
		
		
		// capture title of the page
//		System.out.println(driver.getTitle());
		String pageTitle = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(pageTitle);
		
		
		
		//Scrolling page till element
		WebElement eleBest  = driver.findElement(By.id("RESULT_RadioButton-9"));
		JavaScriptUtil.scrollIntoView(eleBest, driver);
		Thread.sleep(3000);
		
		
		// Scrolling to the bottom of screen
		JavaScriptUtil.scrollPageDown(driver);
		
		
		
		// click on some element
//		driver.navigate().to("https://www.twoplugs.com/");
		WebElement eleSubmitBtn =driver.findElement(By.id("FSsubmit"));
		JavaScriptUtil.clickElementByJS(eleSubmitBtn, driver);
		Thread.sleep(3000);
		
		
		
		// Generate alert info
		JavaScriptUtil.generateAlert(driver, "You clicked on Submit button......");
		
				
		
		// Refreshing page
//		driver.navigate().refresh();
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		

		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();


	}

}
