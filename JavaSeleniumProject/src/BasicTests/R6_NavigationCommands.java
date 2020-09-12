package BasicTests;

// Navigation Commands	
//-navigate().forward()
//-navigate().back()
//-navigate().to()
//-navigate().refresh()


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class R6_NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/");	// used to open the URL
		System.out.println("First URL opened title is: "+ driver.getTitle());
		
		Thread.sleep(5000);
		driver.navigate().to("http://www.facebook.com");	// navigating to another site
		System.out.println("Second URL opened title is : "+ driver.getTitle());
		
		
		driver.navigate().back();	//navigating back using browser back button
		Thread.sleep(5000);
		System.out.println("Title after back action : "+driver.getTitle());
		
		
		driver.navigate().forward();	// navigating forward using browser forward button
		Thread.sleep(5000);
		System.out.println("Title after forward action is: "+driver.getTitle());
		
		
		driver.navigate().refresh();	// refreshing page using browser refresh button.
		Thread.sleep(5000);
		System.out.println("Title after refresh action is : "+driver.getTitle());
		
		driver.close();


	}

}
