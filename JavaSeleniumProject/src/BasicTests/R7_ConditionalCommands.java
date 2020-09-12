package BasicTests;

// Conditional Commands
//-isDisplayed()
//-isEnabled()
//-isSelected()

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class R7_ConditionalCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\'email\']"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\'pass\']"));
		
		System.out.println(email.isDisplayed());	//check element is displayed or not
		System.out.println(email.isEnabled());		// check element is enabled or not
		
		if(email.isDisplayed() && email.isEnabled())
		{
			email.sendKeys("hi");
		}
		
		if(password.isDisplayed() && password.isEnabled())
		{
			password.sendKeys("Bye");
		}
		
		System.out.println("Female status: "+driver.findElement(By.xpath("//*[@id=\'u_0_6\']")).isSelected());
		
		System.out.println("Male status: "+driver.findElement(By.xpath("//*[@id=\'u_0_7\']")).isSelected());
		
		//Select Male radio button
		if(driver.findElement(By.xpath("//*[@id=\'u_0_6\']")).isSelected()==false)
		{
			driver.findElement(By.xpath("//*[@id=\'u_0_7\']")).click();
		}
		
		System.out.println("Male status after click: "+driver.findElement(By.xpath("//*[@id=\'u_0_7\']")).isSelected());
		
		Thread.sleep(5000);
		driver.close();

	}

}
