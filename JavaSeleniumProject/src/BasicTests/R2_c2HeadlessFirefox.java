package BasicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class R2_c2HeadlessFirefox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\geckodriver.exe");
		
		// Making Firefox headless
		FirefoxOptions options = new FirefoxOptions();
//		options.setHeadless(true);		// 1st method
		options.addArguments("--headless");		// 2nd method
		
		
		WebDriver driver = new FirefoxDriver(options);
		
		
		driver.get("http://demo.nopcommerce.com/");
		
		System.out.println("The title of the page is : "+ driver.getTitle());


	}

}
