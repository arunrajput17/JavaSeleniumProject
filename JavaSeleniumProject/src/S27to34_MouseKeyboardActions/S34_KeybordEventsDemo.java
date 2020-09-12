package S27to34_MouseKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class S34_KeybordEventsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/text-box");
		
		System.out.println("Start");
		
	     //Find web elements
		WebElement userName = driver.findElement(By.id("userName"));
		WebElement currAddr = driver.findElement(By.id("currentAddress"));
		WebElement perAddr = driver.findElement(By.id("permanentAddress")); 
		WebElement submitButton = driver.findElement(By.id("submit"));
		
		//Instantiate Actions class
		Actions act = new Actions(driver);
		
//		userName.sendKeys("hi", Keys.ENTER); 	// using driver and keyboard
		act.sendKeys(userName, "Mr Jones").perform();	// using mouse and keyboard events
		
		//Enter current address 
	    act.click(currAddr).sendKeys("1205 OAK STREET,OLD FORGE,NEW YORK,11240").perform();
	    
	    //Copy current address 
	    act.keyDown(currAddr,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); 
	    Thread.sleep(5000);
	    act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(perAddr,Keys.CONTROL).perform();
	    Thread.sleep(5000);
	 
	    //Paste current address in permanant adderss text field
	    act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    Thread.sleep(5000);
	    
	    //Click on Submit button
	    System.out.println(submitButton.isEnabled());
	    if(submitButton.isEnabled()==true)
	    {
//	    	act.click(submitButton).perform();
	    	submitButton.click();
	    }
	    else
	    {
	    	System.out.println("Button not enabled");
	    }
	    
	     
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
