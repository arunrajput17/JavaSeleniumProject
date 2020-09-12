package S35to38_UploadDownloadFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class S38_DownloadZipFileInFirefox {

	public static void main(String[] args) throws InterruptedException {
		// Creating browser profile
		FirefoxProfile profile = new FirefoxProfile();
		
		// Set preference to not show file download confirmation dialogue using firefox
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip");	// set MIME Type https://www.sitepoint.com/mime-types-cpmplete-list/
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		// Set preference for downloading file in particular directory
		profile.setPreference("browser.download.dir", "D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles");
		profile.setPreference("browser.download.folderList", 2);
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(option);	// passing options in driver
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://testingmasters.com/student-corner/downloads/");
		
		System.out.println("Start");
		
		driver.findElement(By.xpath("//*[@id=\"tablepress-7\"]/tbody/tr[1]/td[2]/a")).click();
	
	
		
		
		System.out.println("End");
		Thread.sleep(5000);
		driver.close();

	}

}
