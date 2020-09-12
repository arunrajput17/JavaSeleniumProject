package S59_XPathFunctionAndAxes;
/*
 * Xpath Axes methods:
 * Xpath methods are used to find the complex or dynamic elements.
 * - Ancestor
 * - Child
 * - Parent
 * - Preceding
 * - Following
 * - Self or Context node
 * - Descendant
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesMethods {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");

		
		System.out.println("Start");
		
		
		
		// -----------------------Ancestors:-------------------------------
		/*
		 * selects all ancestors element (grandparent, parent, etc.) of the current node
		 * 
		 *  //employee/ancestor::* ----> Select all ancestor node of the employee node
		 *  //ancestor::name	--------> Select all ancestor of the name node in context node
		 */
		
		System.out.println("Ancestor Example :");
		
		
		// -----------------------Child:-------------------------------
		/*
		 * selects child of the context node
		 * 
		 *  //child::* 			----> Select all child nodes of the context node
		 *  //child::employee	----> Select all child elements of the employee node
		 */
		
		
		// -----------------------Parent:-------------------------------
		/*
		 * select the parent node of the context node
		 * 
		 *  //name/parent::* 			----> Select parent node of the 'name' context node
		 *  //email/parent::employee	----> Return result node if employee node is parent node
		 *  									of the context node, otherwise no node found
		 */
		
		
		// -----------------------Preceding:-------------------------------
		/*
		 * selects all nodes before the context node, excluding attributes node or namespaces
		 * 
		 *  //employee[@id=3]/preceding::employee	----> Select all nodes (with child nodes) before the context node
		 */
		
		//finding preceding of facebook create new account : password field
//		//input[@id='password_step_input']/preceding::input
		
		// To find specific element
//		//input[@id='password_step_input']/preceding::input[2]
		
		
		
		
		
		// -----------------------Following:-------------------------------
		/*
		 * selects all the nodes after the context node, excluding attributes node or namespaces node.
		 * 
		 *  //employee[@id=1]/following::employee	----> Select all nodes (with child nodes) after the context node
		 */
		
		//finding following of facebook create new account : password field
//		//input[@id='password_step_input']/following::input
		
		// To find specific element
//		//input[@id='password_step_input']/following::input[3]
		
		
		
		// -----------------------Self:-------------------------------
		/*
		 * selects the current node 'name'
		 * 
		 *  //name/self::*
		 */
		
		
		
		// -----------------------Descendant:-------------------------------
		/*
		 * selects all the descendants (children, grandchildren, etc) of the current node 
		 * 
		 *  //descendant::employee	----> Select all the descendant of the employee node in context node
		 */
		
		
	}

}
