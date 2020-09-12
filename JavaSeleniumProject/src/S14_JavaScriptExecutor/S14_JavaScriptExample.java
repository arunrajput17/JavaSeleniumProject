package S14_JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class S14_JavaScriptExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	// Typecast driver to JavaScriptExecutor
		
		// -----Alert----
//		js.executeScript("alert('Welcome to JavaScript')");
		
//		js.executeScript("prompt('Enter name')");
		
//		js.executeScript("confirm('Are you sure?')");
		
		
		// ---------------Typing in Textbox-----------
		// It will handle all textbox which we are not able to enter data using SEndKeys due to some properties
		// DisAdv - it will event insert data in disabled text box
		
//		js.executeScript("document.getElementById('RESULT_TextField-1').value='John'");	//1st method
		
		WebElement eleFirst = driver.findElement(By.id("RESULT_TextField-1"));	
//		js.executeScript("arguments[0].value='Mike'", eleFirst);	// 2nd Method
		
		// 3rd method to dynamically pass value also
		js.executeScript("arguments[0].value=arguments[1]", eleFirst,"DyanamicName");
		
		
		
		Thread.sleep(5000);
		
		
		// ----------Radio button-------------
		WebElement eleMale = driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
		
		js.executeScript("arguments[0].click()", eleMale);	// 1st method
		
//		js.executeScript("arguments[0].checked=true", eleMale);	// 2nd method
		
//		js.executeScript("document.getElementById('RESULT_RadioButton-7_0').click();");	//3rd method
		
		
		// -------------check box--------------
		WebElement eleSun = driver.findElement(By.cssSelector("input#RESULT_CheckBox-8_0"));
		WebElement eleSat = driver.findElement(By.cssSelector("input.multiple_choice[value=CheckBox-6]"));
		
		js.executeScript("arguments[1].click();arguments[0].click();", eleSun,eleSat);	//1st method
		
//		js.executeScript("arguments[0].checked=true; arguments[1].checked=true;", eleSun,eleSat);	//2nd method
		
//		js.executeScript("document.getElementById('RESULT_CheckBox-8_0').click()");	//3rd method
		
		
		// -------- auto suggest dropdown---------------
//		js.executeScript("document.querySelectorAll('.react-autosuggest__suggestions-list')[0].children[0].click()");	//makemytrip
		
		
		//-----------calendar date picker--------------
//		js.executeScript("document.querySelectorAll('.DayPicker-Day')[28].click();");	//makemytrip
		
		
		//--------------Scroll to bottom of screen------------
		// scroll("(horizontal, vertical)");
		
//		js.executeScript("scroll(0,200)");
		
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
//		js.executeScript("window.scrollTo(0, '+y+')");
		
		
		//---------------Scroll to particular webelement------------
		
		driver.navigate().to("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		
		//Identifying the webElement which will appear after scrolling down
		WebElement eleContainer = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
		
		// now execute query which will actually scroll until that element is not appeared on page
		js.executeScript("arguments[0].scrollIntoView(true);",eleContainer);
		
		//Extract the text and verify
		System.out.println(eleContainer.getText());
		
		
		//------------Highlight element method--------------
		
		
		driver.navigate().to("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		Thread.sleep(3000);
		
		WebElement eleCountry = driver.findElement(By.xpath("//input[@id='RESULT_TextField-4']"));
		
		//Highlighting field
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", eleCountry);
		Thread.sleep(2000);
		
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
