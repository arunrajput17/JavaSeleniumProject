package S39_RobotAPIDownloadfile;

// Robot Class
// - In certain Selenium automation tests, there is need to control keyboard or mouse to interact with OS windows
//	 like Download pop up, alerts, Print pop-ups etc.
// - Selenium Webdriver cannot handle these OS pop ups / applications.

// ----- Benefits of Robot Class----
// - Robot class can simulate Keyboard and mouse events
// - Robot class can help in upload /download of files when using selenium webdriver
// - Robot class can easily be integrated with current automation framework (keyword, data-driven, hybrid)





import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S39_RobotAPIDemoKeyboardUseDownloadfile {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	// passing options in driver
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		System.out.println("Start");
		
		// Download a text file
		driver.findElement(By.id("textbox")).sendKeys("Testing text file");
		driver.findElement(By.id("createTxt")).click();		// click on generate file button
		driver.findElement(By.id("link-to-download")).click(); 		// Download file on default location
		Thread.sleep(3000);
		
		// Robot
		Robot robot = new Robot();
		
		/* Down arrow
		 * 3 times tab
		 * Enter
		 */
		
		robot.keyPress(KeyEvent.VK_DOWN);	// press down arrow key in keyboard
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_TAB);	// press TAB key of keyboard
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);	// press enter key in keyboard
		Thread.sleep(3000);
		
		
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();

	}

}
