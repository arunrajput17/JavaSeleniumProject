package BasicTests;

// Browser commands
//-close()	
//-quit()	

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class R5_CloseAndQuitCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.get("http://www.popuptest.com/popuptest2.html");
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		
//		driver.close();	// close current window
		
		driver.quit();	// closes multiple browsers or windows


	}

}
