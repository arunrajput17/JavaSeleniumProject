package S51_ZxingAPIBarcodeQRCode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class A1_ReadTextFromBarCode {

	public static void main(String[] args) throws InterruptedException, IOException, NotFoundException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Start");
		Thread.sleep(2000);
		
		// Capture Barcode
//		String barCodeURL = driver.findElement(By.xpath("//*[@id='HTML12']/div[1]/img[1]")).getAttribute("src"); //First barcode
		String barCodeURL = driver.findElement(By.xpath("//*[@id='HTML12']/div[1]/img[2]")).getAttribute("src"); // Second barcode
		System.out.println(barCodeURL);
		
		URL url = new URL(barCodeURL);
		
		BufferedImage bufferedImage = ImageIO.read(url);
		
		//Zxing API class
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		//Decode binaryBitmap
		Result result = new MultiFormatReader().decode(binaryBitmap);
		
		System.out.println("Barcode text is : "+result.getText());
		
		
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
