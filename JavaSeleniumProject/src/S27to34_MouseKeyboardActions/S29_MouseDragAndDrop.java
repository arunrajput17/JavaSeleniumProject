package S27to34_MouseKeyboardActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S29_MouseDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		System.out.println("Start");
		
		
		// created object of actions class
		Actions act = new Actions(driver);		
		
		
		// 3) Drag and drop
		
		Thread.sleep(3000);
		
		// identifying source and target elements
		WebElement source_element = driver.findElement(By.id("box6"));
		WebElement target_element = driver.findElement(By.id("box106"));
		
		// 1st method
//		act.dragAndDrop(source_element, target_element).build().perform();	// Drag and drop element
		
		// 2nd Method
		act.clickAndHold(source_element).moveToElement(target_element).release().build().perform();
		
		System.out.println("Drag and drop completed");
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();

	}

}
