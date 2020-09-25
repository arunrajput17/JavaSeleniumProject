package S40_FileUploadUsingAutoIT;
/*
 * AutoIT is a third party tool used for automating window based applications.
 * 
 * Two Components needed are:
 * 1) AutoIT - Identifying elements on the window
 * 				Download link - https://www.autoitscript.com/cgi-bin/getfile.pl?autoit3/autoit-v3-setup.exe
 * 2) AutoIT editor - writing AutoIT scripts
 * 				Download link - https://www.autoitscript.com/cgi-bin/getfile.pl?../autoit3/scite/download/SciTE4AutoIt3.exe
 * 
 * Installation Location: C:\Program Files (x86)\AutoIt3\
 * 
 * Invoke AutoIt : C:\Program Files (x86)\AutoIt3\Au3Info_x64.exe
 * Invoke AutoIT Editor : C:\Program Files (x86)\AutoIt3\SciTE\SciTE.exe
 * 
 * Steps to integrate AutoIT with Selenium webdriver:
 * --------------------------------------------------
 * 1) Write AutiIT script for file uploading (AutoIT Editor)
 * 			ControlFocus() --> focus on the text box
 * 			ControlSetText() --> providing path of the file
 * 			ControlClick() --> clicking an open button
 * 
 *  
 *  AutoIT Script
 *  ---------------------
 *  Sleep(500)
 *  ControlFocus("Open","","Edit1")
 *  Sleep(500)
 *  ControlSetText("Open","","Edit1",$CmdLine[1])
 *  Sleep(500)
 *  ControlClick("Open","","Button1")
 *  Sleep(500)
 * 
 * 
 *  2) Compile AutoIT script and generate .exe file
 *  	Tools --> Compile --> Select x64 --> Compile --> generated .exe file
 *  3) use .exe file in selenium webdriver script
 *  Runtime.getRuntime().exec("D:\\au\\UploadFileScript.exe"+" "+"D:\\au\\sample.PNG");
 * 
 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S40_FileUploadUsingAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		
		System.out.println("Start");
		
		Thread.sleep(5000);
		
		// Mouse action
		Actions act = new Actions(driver);
		
		// Uploading file
		WebElement chooseFileButton =driver.findElement(By.id("input-4"));
		Thread.sleep(3000);
		
		// Click browse button
		act.moveToElement(chooseFileButton).click().build().perform();	
		
		//To execut EXE file (EXE path, File to be uploaded path)
//		Runtime.getRuntime().exec("D:\\Day Shift\\Selenium_Prequisites\\AutoIT\\ScriptUpload\\UploadFileScript.exe"+" "+ "D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\sample.PNG");
		
		Runtime.getRuntime().exec("D:\\au\\UploadFileScript.exe"+" "+"D:\\au\\sample.PNG");
		
			
		
		
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();


	}

}
