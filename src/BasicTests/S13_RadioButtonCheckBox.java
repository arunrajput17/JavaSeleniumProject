package BasicTests;

// Radio buttons and check boxes

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S13_RadioButtonCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		
		boolean status_MaleRadio;
		
		// 1. To verify whether the radio button is already selected or not
		status_MaleRadio = driver.findElement(By.xpath("//*[@id='RESULT_RadioButton-7_0']")).isSelected();
		System.out.println("Male Radiobutton selected status :"+status_MaleRadio);
		
		
		// 2. How to click or select 
//		driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']")).click();
		
		
		//alternate way of click using javacsript
		WebElement eleMale = driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", eleMale);	// 1st method
		
//		js.executeScript("arguments[0].checked=true", eleMale);	// 2nd method
		
//		js.executeScript("document.getElementById('RESULT_RadioButton-7_0').click();");	//3rd method
		
				
		status_MaleRadio = driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']")).isSelected();
		System.out.println("Male Radiobutton status after selection :"+status_MaleRadio);
		
		
		// 3. working with check box
		WebElement eleSun = driver.findElement(By.cssSelector("input#RESULT_CheckBox-8_0"));
		WebElement eleSat = driver.findElement(By.cssSelector("input.multiple_choice[value=CheckBox-6]"));
		
		System.out.println("Sunday checkbox status :"+eleSun.isSelected());
		System.out.println("Saturday Checkbox status :"+eleSat.isSelected());
		
		// 4. Selecting checkboxes
//		eleSun.click();
		
		// -- alternate way with Javascript executor
		
		js.executeScript("arguments[1].click();arguments[0].click();", eleSun,eleSat);	//1st method
		
//		js.executeScript("arguments[0].checked=true; arguments[1].checked=true;", eleSun,eleSat);	//2nd method
		
//		js.executeScript("document.getElementById('RESULT_CheckBox-8_0').click()");	//3rd method
		
		
		System.out.println("Sunday checkbox status After :"+eleSun.isSelected());
		System.out.println("Saturday Checkbox status After :"+eleSat.isSelected());
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
