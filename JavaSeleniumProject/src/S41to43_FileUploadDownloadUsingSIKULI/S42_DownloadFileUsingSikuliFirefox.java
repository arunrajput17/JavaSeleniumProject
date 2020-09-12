package S41to43_FileUploadDownloadUsingSIKULI;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S42_DownloadFileUsingSikuliFirefox {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		System.out.println("Start");
		
		// Download a text file
		driver.findElement(By.id("textbox")).sendKeys("Testing text file");
		driver.findElement(By.id("createTxt")).click();		// click on generate file button
		driver.findElement(By.id("link-to-download")).click(); 		// Download file on default location
		Thread.sleep(5000);
		
		// Checking file is available or downloaded at path or not
		if (isFileEXist("C:\\Users\\arunk\\Downloads\\info.txt"))
		{
			System.out.println("File exists");
		}
		else
		{
			System.out.println("File not exists");
		}
		
		
		
		
		// Download pdf file
		driver.findElement(By.id("pdfbox")).sendKeys("Testing pdf file");
		driver.findElement(By.id("createPdf")).click();		// click on generate file button
		driver.findElement(By.id("pdf-link-to-download")).click(); 		// Download file on default location	
		Thread.sleep(5000);
		
		// Checking file is available or downloaded at path or not
		if(isFileEXist("C:\\Users\\arunk\\Downloads\\info.pdf"))
		{
			System.out.println("File exists");
		}
		else
		{
			System.out.println("File not exists");
		}
	
		
		
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();



	}
	
	static boolean isFileEXist(String path)
	{
		File f = new File(path);
		
		if(f.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
