package BasicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Headless Browser & headless testing
// -- A headless browser is a browser simulation program that does not have a user interface (UI less).
// -- Headless browser programs operate like any other browser, but do not display any UI.
// Selenium executes its tests in the background.
// -- There are several headless browsers available in the market, the following are the most
// popular ones:
// * Chrome
// * Firefox
// * HTMLUnitDriver
// * PhantomS

// What is headless testing?
// -- Executing the web applications UI tests without opening a browser's user interface is called
// headless browser testing. Headless browser acts similar to a normal web browser.
// -- Testers have full control over the web pages loaded into the headless browsers. Only
// difference is you will not see a graphical user interface.

// when to use headless browser
// -- We can use headless testing once the cross browser testing is completed and want to run 
// regression test cases in subsequent releases and with continuous integration.
// -- You have no option other than using headless testing when your machine does not have a GUI,
// for instance if you want to run tests in unix.
// -- It is recommended to use headless browser when tests are executed in parallel as User
// interface based browsers consumes a lot of Memory / resources. 

// disadvantages of headless browser
// -- Headless browsers are a bad idea. They get you some testing, but nothing like what a real
// user will see, and they mask lots of problems that only real browsers encounter.
// -- Hard to debug inconsistent failures on locating elements due to page loading too fast.
// --In real browser as functions are performing in front of user and he can interact with it so 
// he can easily detect where the tests goes fail. And can easily debug if anything goes wrong.
// -- Headless browsers aren't representing real users, as no user uses your application
// without UI. Because it does not have UI, it may not report errors related with images.
// -- Managing to take screenshot is very difficult in UI less browser


// headless automation in selenium
// -- We can automate the headless browser in selenium, only automation can be performed on 
// headless browser.
// -- For users, there is no such thing called Headless or UI less browser as their eyes cannot 
// see the UI less browser.
// -- In the headless browser we can execute the tests created on UI browsers, so debugging
// occurs on the UI browsers only

// headless chrome browser
// headless firefox browser
// htmlUnitDriver



public class R2_c1HeadlessBrowserTestingChrome {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		
		// Making chrome headless
		ChromeOptions options= new ChromeOptions();
//		options.setHeadless(true);		// 1st method
		options.addArguments("--headless"); 	// 2nd method
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://demo.nopcommerce.com/");
		
		System.out.println("Title of the page : "+ driver.getTitle());
		

	}

}
