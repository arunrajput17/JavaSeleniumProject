package S17n18_Links;
//How to find Broken links
//--------------------------------
//A broken link or dead link is a link on a web page that no longer works because the website
//is encountering one or more of the reasons below:

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

//1) An improper URL entered for the link by the website owner.
//2) The destination website removed the linked web page ( causing what is known as a 404 error)
//3) The destination website permanently moved or no longer exists

//Broken links can be problematic for website visitors, making them unable to access the desired 
//resource or information.



import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S18_BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
//		driver.get("https://www.acroxrm.com/XRMRefsite/newuserlogin.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Start");
		
//		//XRM
//		driver.findElement(By.xpath("//input[@id='btnQueNo']")).click();
//		driver.findElement(By.xpath("//input[@id='TextBoxUserID']")).sendKeys("acroxrm");
//		driver.findElement(By.xpath("//input[@id='TextBoxPassword']")).sendKeys("Tigers@1234");
//		driver.findElement(By.xpath("//input[@id='ButtonLogin']")).click();
//		Thread.sleep(5000);
//		System.out.println(driver.getTitle());
//		Thread.sleep(2000);
		
		
		
		
		// Capture links from a webpage
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		//Number of links
		System.out.println(links.size());
		
		for(int i=0; i<links.size(); i++)
		{
			//by using href attribute we can get URL of required link
			WebElement element =links.get(i);
			String url = element.getAttribute("href");
//			System.out.println(element.getAttribute("href"));
			
			try
			{
				
				URL link = new URL(url);
				
				// creating a connection using url object 'link'
				HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
				
//				Thread.sleep(2000);
				
				//establish connection
				httpCon.connect();
				
				//Capturing response code
				int rescode = httpCon.getResponseCode(); // return response if res code is above 400: broken link
				
				if(rescode>=400)
				{
					System.out.println(url+"  -  "+ " is broken link");
				}
				else
				{
					System.out.println(url+"  -  "+ " is valid link");
				}
			}
			catch(Exception e)
			{
				System.out.println("Error message : "+e+"------" +element.getText());
			}
			
			
		}
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
