package S27to34_MouseKeyboardActions;
/*
** keyDown(modifier_key) 	Performs a modifier key press. Does not release the modifier key - subsequent interactions may assume it's kept pressed.
	Parameters:
				modifier_key - any of the modifier keys (Keys.ALT, Keys.SHIFT, or Keys.CONTROL) 

** keyUp(modifier _key) 	Performs a key release.
	Parameters:
				modifier_key - any of the modifier keys (Keys.ALT, Keys.SHIFT, or Keys.CONTROL)

** sendKeys(onElement, charsequence) 	Sends a series of keystrokes onto the element.
	Parameters:
				onElement - element that will receive the keystrokes, usually a text field
				charsequence - any string value representing the sequence of keystrokes to be sent 

*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class S33_MouseKeys {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		String baseUrl = "http://www.facebook.com/"; 
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		System.out.println("Start");
		
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();

	}

}
