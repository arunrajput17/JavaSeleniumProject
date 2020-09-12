package S17n18_Links;

//Links are accessed using the click() method.
//Apart from the locators available for any WebElement, Links also have link text based locators:

// By.linkText() – locates the links based on the exact match of the link's text provided as a parameter.
// By.partialLinkText() – locates links based on the partial text match of the link's text.

//Both the above locators are case Sensitive.

// findElements() & By.tagName("a") method finds all the elements in the page matching the locator criteria 
//Links can be accessed by the By.linkText() and By.partialLinkText() whether they are inside or outside block-level elements.


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S17_Links {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
		//How many links present using common tagname 'a' mostly used
		List<WebElement> eleAllLinks =driver.findElements(By.tagName("a"));
		System.out.println("Number of links present are: "+ eleAllLinks.size());
		
		
		// Capture links
		for(WebElement link : eleAllLinks)
		{
			System.out.println(link.getText());
		}
		
		
		//Click on the links
		driver.findElement(By.linkText("REGISTER")).click();	// with LinkText
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("SUP")).click();	// using Partial link text
		
		
		/*
		How to get Multiple links with the same Link Text

		So, how to get around the above problem? In cases where there are multiple links with the 
		same link text, and we want to access the links other than the first one, how do we go 
		about it?

		In such cases, generally, different locators viz... By.xpath(), By.cssSelector() or 
		By.tagName() are used.

		Most commonly used is By.xpath(). It is the most reliable one but it looks complex and 
		non-readable too. 
		*/
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
		

	}

}
