package S50_AShotAPI;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class A1_CaptureLogoImage {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Start");
		Thread.sleep(2000);
		
		// Logo Image element
		WebElement logoImageElement = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		
		// Taking logo screenshot
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		
		//Capture the image and store at particular location
		ImageIO.write(logoImageScreenshot.getImage(),"png", new File("./TestFiles/OrangeHRMlogo.png"));
		
		// verify that file exists or not
		File f = new File("./TestFiles/OrangeHRMlogo.png");
		
		if(f.exists())
		{
			System.out.println("Image file Captured");
		}
		else
		{
			System.out.println("Image file not exist");
		}
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
