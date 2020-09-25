package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {
	
	
	// This method is for Taking screenshot
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try {
			// Typecasting TakesScreencast
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			// Creating source
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			// copying file from source to destination
			FileUtils.copyFile(source, new File("./TestFiles/"+screenshotName+".png"));
			
			System.out.println("Screenshot Taken");
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

}
