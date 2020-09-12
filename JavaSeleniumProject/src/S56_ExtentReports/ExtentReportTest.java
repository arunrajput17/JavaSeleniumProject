package S56_ExtentReports;
/*
 * Classes of Extent Report: 
 * ExtentHtmlReporter
 * ExtentReports
 * ExtentTest
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import junit.framework.Assert;



public class ExtentReportTest {
	
	WebDriver driver;
	
//	public ExtentHtmlReporter htmlReporter;	//Use in extent report version 4.1.7
	public ExtentSparkReporter htmlReporter;	// use in extent report version 5.0.3
	public ExtentReports extent;
	public ExtentTest test;
	
	
	@BeforeTest
	public void setExtent()
	{
//		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./TestFiles/myReport.html"); //Use in extent report version 4.1.7
//		htmlReporter = new ExtentHtmlReporter("./TestFiles/myReport.html");	//Use in extent report version 4.1.7
		
		htmlReporter = new ExtentSparkReporter("./TestFiles/myReport.html");	// use in extent report version 5.0.3

		
		htmlReporter.config().setDocumentTitle("Automation Report");	// Title of the report
		htmlReporter.config().setReportName("Functional Report");		// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);			// Setting theme odf report
		
//		htmlReporter.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST }).apply(); //To set view order
		
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Mike");
		extent.setSystemInfo("Browser", "Chrome");
		
		
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.nopcommerce.com/");
		
	}
	
	
	@Test
	public void noCommerceTitleTest()
	{
		test=extent.createTest("noCommerceTitleTest");	//This will create new entry in the extent report
		
		String title = driver.getTitle();
		System.out.println("Title is : "+title);
		Assert.assertEquals("nopCommerce demo store", title, "Page title doesnt match");

	}
	
	
	@Test
	public void noCommerceLogoTest()
	{
		test = extent.createTest("noCommerceLogoTest");
		
		Boolean status = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		Assert.assertTrue(status);
		
	}
	
	
	@Test
	public void noCommerceLoginTest()
	{
		test = extent.createTest("noCommerceLoginTest");
		
		//Adding sub node
		test.createNode("Login with valid input");
		Assert.assertTrue(true);
		
		test.createNode("Login with invalid input");
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, " TEST CASE FAILED IS "+ result.getName()); 	// to add name in extent report
			test.log(Status.FAIL, " TEST CASE FAILED IS "+ result.getThrowable()); 	// to add error exception in extent report
			
			String screenshotPath = ExtentReportTest.getScreenshot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);	//adding screen shot
						
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case SKIPPED is "+ result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case PASSED is "+ result.getName());
		}
		
		driver.quit();
		
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName +".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
	}
	

}
