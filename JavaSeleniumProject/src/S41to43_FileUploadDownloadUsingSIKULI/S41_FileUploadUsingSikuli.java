package S41to43_FileUploadDownloadUsingSIKULI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class S41_FileUploadUsingSikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed   {
		
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
		
		// images file path
		String imageFilePath ="D:\\au\\SK\\";
		
		// input file path
		String inputFilePath = "D:\\au\\";
		
		Screen s = new Screen();
		
		// Passing screenshot path
		Pattern fileInputTextbox = new Pattern(imageFilePath+"Sk1fileuploadCapture.PNG");
		Pattern openButton = new Pattern(imageFilePath+"SKOpenButtonCapture.PNG");
		Thread.sleep(5000);
		
		s.wait(fileInputTextbox, 20);	// it will wait for this to appear on screen
		s.type(fileInputTextbox,inputFilePath+"sample.PNG");	// Path of screenshot and file to be uploaded
		s.click(openButton);	// click on open button
		
				
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();

	}

}
