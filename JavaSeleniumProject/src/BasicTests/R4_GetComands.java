package BasicTests;

// Get commands
//-get()
//-getTitle()
//-getPageSource()
//-getCurrentUrl()
//-getText()

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class R4_GetComands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Get commands
		driver.get("http://demo.guru99.com/test/newtours/");	// used to open the URL

		
		System.out.println(driver.getTitle());	//returns title of the page
//		System.out.println(driver.getPageSource());	//returns page source code
		System.out.println(driver.getCurrentUrl());	//returns URL of the page
		
		String txtDate=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")).getText();
		System.out.println(txtDate);
		
		
		driver.close();	// close current window
		

	}

}
