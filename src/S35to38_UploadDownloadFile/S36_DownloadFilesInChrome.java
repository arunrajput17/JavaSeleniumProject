package S35to38_UploadDownloadFile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class S36_DownloadFilesInChrome {

	public static void main(String[] args) throws InterruptedException {
		
		String fileDownloadPath = "D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles";
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", fileDownloadPath);
		chromePrefs.put("download.prompt_for_download", "false");
		
		
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", chromePrefs);		// Set preference for downloading file in particular directory
		
		
		// this for ssl certificate
//		option.addArguments("--test-type");
//		option.addArguments("--disable-extensions");
//		DesiredCapabilities cap = DesiredCapabilities.chrome();  
//		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
//		cap.setCapability(ChromeOptions.CAPABILITY, option);  
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		System.out.println("Start");
		
		// Download a text file
		driver.findElement(By.id("textbox")).sendKeys("Testing text file");
		driver.findElement(By.id("createTxt")).click();		// click on generate file button
		driver.findElement(By.id("link-to-download")).click(); 		// Download file on default location
		
		// Download pdf file
		driver.findElement(By.id("pdfbox")).sendKeys("Testing pdf file");
		driver.findElement(By.id("createPdf")).click();		// click on generate file button
		driver.findElement(By.id("pdf-link-to-download")).click(); 		// Download file on default location		
	
		
		
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();
	

	}

}
