package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.History;

public class JavaScriptUtil {
	
	
	//--------------Flashing Element Method-----------
	public static void flash(WebElement element, WebDriver driver)
	{
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0; i<500; i++)
		{
			changeColor("#000000", element, driver); 	// 1
			changeColor(bgcolor, element, driver);		// 2
		}
	}
	
	
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		
		try {
			Thread.sleep(20);
		} 
		catch (InterruptedException e) {
		}
		
	}
	
	
	
	// --------------Drawing a border around the element--------------------
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	
	
	//----------------capture title of the page----------------------------
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	
	
	// ---------------------Click element ----------------------------------
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	
	
	//--------------------Generate alert info-------------------------------
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	
	
	//---------------------Refresh Page-------------------------------------
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	
	//----------------------Scrolling page till we find element-------------
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
	//---------------------Scrolling page downn till end------------------
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	

}
