package BasicTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S45_HandlingCookies {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		System.out.println("Start");
		
		//  1. Capture all cookies from browser
		Set<Cookie> cookies = driver.manage().getCookies();
		
		// 2. Count number of cookies
		System.out.println("Size of Cookies : "+cookies.size());
		System.out.println("");
		
		// 3. Read All Cookie pair
//		System.out.println(cookies);
		
		// Read all cookies one by one
		for(Cookie cookie:cookies)
		{
//			System.out.println(cookie);	// print all cookies details
			
			// Printing only name and value of cookies
			System.out.println(cookie.getName()+" : "+ cookie.getValue());
			
		}
		
		// 4. Getting specific cookie by name
		System.out.println("");
		System.out.println("This is specific cookie finding by name :"+driver.manage().getCookieNamed("session-id"));
		System.out.println("");
		
		
		// 5. Adding new cookies
		Cookie cobj = new Cookie("MyCookie","1234567890");
		driver.manage().addCookie(cobj);
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of cookie after addning new "+cookies.size());
		System.out.println("Printing newly added coookie : "+driver.manage().getCookieNamed("MyCookie"));
		System.out.println("");
		
		
		// 6. Deleting specific cookie by using name of cookie
//		driver.manage().deleteCookieNamed("MyCookie");	// By name
		driver.manage().deleteCookie(cobj); 	//new cookie object
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of cookie after deleting new cookie "+cookies.size());
		System.out.println("Printing coookies after deleting newly added cookie : ");
		for (Cookie cookie : cookies)
		{
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		System.out.println("");
		
		// 7. Deleting all the cookies
		driver.manage().deleteAllCookies();
		
		cookies = driver.manage().getCookies();
		System.out.println("Size of the cookies after deleting all the cookies : "+cookies.size());
		System.out.println("Printing cookies after deleting all : "+cookies);
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
