package BasicTests;
//Locators :
//1. ID
//2. Name
//3. Link Text
//4. CSS Selector
//	-- Tag and ID
//	-- Tag and Class
//	-- Tag and attribute
//	-- Tag, class and attribute
//	-- Inner Text
//5. XPath

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class S11_Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// Site used is http://demo.guru99.com/test/newtours/index.php
		
		// 1. ID
		driver.findElement(By.id("email")).sendKeys();	// from facebook
		
		
		// 2. Name
		// Site used is http://demo.guru99.com/test/newtours/index.php
		// <input type="text" name="userName" size="10">
		driver.findElement(By.name("userName")).sendKeys();
		
		
		// 3. Link Text
		// Site used is http://demo.guru99.com/test/newtours/index.php
		// For links we have 'a' as an anchor tag
		// <a href="register.php" style="color: #0000ee;text-decoration: underline;">REGISTER</a>
		driver.findElement(By.linkText("REGISTER")).click();;
		
		
		
		
		// 4. CSS Selector (Cascading style sheet)

		// Facebook email field
		// <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">
		
		//-- Tag and ID		( tag is input and ID is email)
		driver.findElement(By.cssSelector("input#email")).sendKeys();
		
		//-- Tag and Class
		driver.findElement(By.cssSelector("input.inputtext login_form_input_box")).sendKeys();
		
		//-- Tag and attribute (attribute can be anything class, type, id etc)
		driver.findElement(By.cssSelector("input[name=email]")).sendKeys();
		
		//-- Tag, class and attribute
		driver.findElement(By.cssSelector("input.inputtext login_form_input_box[data-testid=royal_email]")).sendKeys();
		
		//-- Inner Text
		// when the object doesn't have id, name, or class attributes, then we use their inner Text
		// Inner texts are the actual strings patterns that the HTML label shows on the page.
		
		// Site used is http://demo.guru99.com/test/newtours/index.php
		// <font face="Arial, Helvetica, sans-serif" size="2">Password:</font>
		driver.findElement(By.cssSelector("font:contains('Password:')")).sendKeys();
		
		
		// 5. xPath :address of web element
		// Types of Xpath:
		
		//(1) Absolute Xpath : complete or full address of the element in the web page (CompleteXpath)
		// Absolute xpath always start with the Single slash /
		
		// facebook -- firstname absolute xpath
		// /html/body/div[1]/div[3]/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/input
		
		
		//(2) Relative Xpath : partial address of the element in the web page (Partial Xpath)
		// Reative xpath always start with double slash
		
		//facebook -- firstname relative xpath
		// //*[@id="u_0_m"]
		
		// writing Xpath manually
		// absolute xpath for Email or phone
		// /html/body/div/div[2]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[1]/input
		
		
		// Relative xpath for 
		// //tagname[@attribute='value']
		// //*[@id='email']		OR 	//input[@id='email']
		
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys();
		
		//------- Using Xpath Handling complex & Dynamic elements in Selenium-----------
		
		// 1) Basic Xpath
		// 	-xpath expression select nodes or list of nodes on the basis of attributes like
		//	ID, Name, Classname, etc.
		
		// 2) Using OR & AND
		// - Xpath = //*[@type='submit' OR @name='btnReset']
		// - Xpath = //*[@type='submit' AND @name='btnReset']
		
		// 3) Using single attributes
		// Example:
		// - //a[@href='http://www.google.com']
		// - //input[@id='name']
		// - //input[@name='username']
		// - //img[@alt='sometext']

		/// 4) Using Multiple attributes
		//	- //tagname[@attribute1='value1'][@attribute2='value2']
		// Example
		// - a[@id='id1'][@name='namevalue1']
		// - img[@src=''][@href='']
		
		
		//-- handle elements whose properties are dynamically changing----
		
		// 5) Using contains method
		// - //tagname[contains(@attribute1,'value1')]
		// Exapmle
		// - //input[contains(@id,'email')]		--> matches with email123 email12 femail abcemail
		// - //input[contains(@name,'')]
		// - //a[contains(@href,'')]
		// - //img[contains(@src,'')]
		// - //div[contains(@id,'')]
		
		
		// 6) Starts with method
		// Xpath= //tagname[starts-with(@attribute1,'value1')]
		// Example
		// - //input[starts-with(@name,'submit')]
		
		//
		
		
	}

}
