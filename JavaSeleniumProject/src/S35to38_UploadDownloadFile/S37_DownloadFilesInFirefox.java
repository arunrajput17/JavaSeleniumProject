package S35to38_UploadDownloadFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;





public class S37_DownloadFilesInFirefox {

	public static void main(String[] args) throws InterruptedException {
				
		// Creating browser profile
		FirefoxProfile profile = new FirefoxProfile();
		
		// Set preference to not show file download confirmation dialogue using firefox
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf");	// set MIME Type https://www.sitepoint.com/mime-types-cpmplete-list/
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		// Set preference for downloading file in particular directory
		profile.setPreference("browser.download.dir", "D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles");
		profile.setPreference("browser.download.folderList", 2);
		
		// set pdf reader disable
		profile.setPreference("pdfjs.disabled", true);	// only for pdf file
		
		
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(option);	// passing options in driver
		
		
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
