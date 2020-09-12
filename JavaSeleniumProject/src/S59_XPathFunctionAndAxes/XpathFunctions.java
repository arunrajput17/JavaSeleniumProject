package S59_XPathFunctionAndAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathFunctions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// Site used is http://demo.guru99.com/test/newtours/index.php
		

		// XPath :address of web element
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
