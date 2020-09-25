package S50_AShotAPI;

import java.awt.image.BufferedImage;
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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class A2_CompareImages {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Start");
		Thread.sleep(2000);
		
		
		// Reading expected image 
//		BufferedImage expectedImage = ImageIO.read(new File("./TestFiles/OrangeHRMlogo.png"));	// This will pass
		
		BufferedImage expectedImage = ImageIO.read(new File("./TestFiles/OrangeHRMlogo-Failed.png"));	// This will fail
		
		// Logo Image element
		WebElement logoImageElement = driver.findElement(By.xpath("//*[@id='divLogo']/img"));
		
		Screenshot logoImageScreenshot= new AShot().takeScreenshot(driver, logoImageElement);
		
		BufferedImage actualImage =logoImageScreenshot.getImage();
		
		//Comparing Images
		ImageDiffer imageDif = new ImageDiffer();
		ImageDiff diff = imageDif.makeDiff(expectedImage, actualImage);
		
		//This will compare two images
		if(diff.hasDiff()==true)	
		{
			System.out.println("Images are not same");
		}
		else
		{
			System.out.println("Images are same");
		}
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
		

	}

}
